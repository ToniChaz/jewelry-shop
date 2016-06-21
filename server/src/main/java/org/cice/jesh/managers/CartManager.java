package org.cice.jesh.managers;

import org.cice.jesh.persistence.dao.impl.CartDaoImpl;
import org.cice.jesh.persistence.entities.CartDto;
import org.cice.jesh.persistence.entities.OrderDto;
import org.cice.jesh.persistence.entities.ProductDto;
import org.cice.jesh.utils.ParserUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by toni on 20/04/16.
 */
public class CartManager {

    CartDaoImpl cartDaoImpl = new CartDaoImpl();
    ProductManager productManager = new ProductManager();
    OrderManager orderManager = new OrderManager();

    public CartManager() {

    }

    public Map<Object, Object> getCart(String id) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null) {

            result.put("statusCode", 400);
            result.put("response", "The cart ID can not be empty");
        } else {

            Integer cartId = ParserUtil.stringToInteger(id);
            CartDto originalCart = getCartByUserId(cartId);

            if (originalCart == null) {
                result.put("statusCode", 404);
                result.put("response", "Cart not found");
            } else {
                result.put("statusCode", 200);
                result.put("response", originalCart);
            }
        }

        return result;
    }

    public Map<Object, Object> update(String id, String productId) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null) {

            result.put("statusCode", 400);
            result.put("response", "The user ID can not be empty");
        } else {

            Integer userId = ParserUtil.stringToInteger(id);
            Integer parsedProductId = ParserUtil.stringToInteger(productId);
            CartDto originalCart = getCartByUserId(userId);
            ProductDto product = productManager.getProductById(parsedProductId);

            if (originalCart == null) {
                CartDto newCart = new CartDto();
                List<ProductDto> productsList = new ArrayList<>();
                productsList.add(product);

                newCart.setUserId(userId);
                newCart.setProductsList(productsList);
                newCart.setTotal();

                result.put("statusCode", 200);
                result.put("response", cartDaoImpl.create(newCart));
            } else {

                originalCart.addProduct(product);
                originalCart.setTotal();

                result.put("statusCode", 200);
                result.put("response", cartDaoImpl.update(originalCart));
            }


        }

        return result;
    }

    public Map<Object, Object> removeProductFromCart(String id, String productId) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null) {

            result.put("statusCode", 400);
            result.put("response", "The user ID can not be empty");
        } else {

            Integer userId = ParserUtil.stringToInteger(id);
            Integer parsedProductId = ParserUtil.stringToInteger(productId);
            CartDto originalCart = getCartByUserId(userId);
            ProductDto product = productManager.getProductById(parsedProductId);


            if (originalCart.getProductsList().contains(product)) {

                originalCart.removeProduct(product);
                originalCart.setTotal();

                result.put("statusCode", 200);
                result.put("response", cartDaoImpl.update(originalCart));
            } else {

                result.put("statusCode", 404);
                result.put("response", "Product not found in cart.");
            }


        }

        return result;
    }

    public Map<Object, Object> transactionComplete(String id) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null) {

            result.put("statusCode", 400);
            result.put("response", "The user ID can not be empty");
        } else {

            Integer userId = ParserUtil.stringToInteger(id);
            CartDto cart = getCartByUserId(userId);

            if (cart == null ) {
                result.put("statusCode", 404);
                result.put("response", "Cart not exist");
            } else {

                OrderDto newOrder = new OrderDto();

                newOrder.setUserId(userId);
                newOrder.setProductsList(cart.getProductsList());
                newOrder.setDate();
                newOrder.setTotal();

                result.put("statusCode", 200);
                result.put("response", orderManager.create(newOrder));
            }


        }

        return result;
    }

    private CartDto getCartByUserId(Integer id) {
        return cartDaoImpl.getCartByUserId("user_id", id);
    }

}
