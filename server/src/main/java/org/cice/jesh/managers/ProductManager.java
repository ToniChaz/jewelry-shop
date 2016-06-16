package org.cice.jesh.managers;

import java.util.HashMap;
import java.util.Map;
import org.cice.jesh.persistence.dao.impl.ProductDaoImpl;
import org.cice.jesh.persistence.entities.ProductDto;
import org.cice.jesh.utils.ParserUtil;

/**
 * Created by toni on 20/04/16.
 */
public class ProductManager {

    ProductDaoImpl productDaoImpl = new ProductDaoImpl();

    public ProductManager() {

    }

    public Map<Object, Object> getAllProducts() {

        Map<Object, Object> result = new HashMap<>();

        result.put("statusCode", 200);
        result.put("response", productDaoImpl.findAll());

        return result;
    }

    public Map<Object, Object> getProduct(String id) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null) {

            result.put("statusCode", 400);
            result.put("response", "The product ID can not be empty");
        } else {

            Integer productId = ParserUtil.stringToInteger(id);
            ProductDto originalProduct = getProduct(productId);
            
            if (originalProduct == null) {
                result.put("statusCode", 404);
                result.put("response", "Product not found");
            } else {
                result.put("statusCode", 200);
                result.put("response", originalProduct);
            }
        }

        return result;
    }

    public Map<Object, Object> findProduct(String query) {
        
        Map<Object, Object> result = new HashMap<>();
        
//        if (query == null || query.length() < 3 ) {
        if (query == null) {
            result.put("statusCode", 400);
            result.put("response", "Need three chars to search products");
        } else {
            result.put("statusCode", 200);
            result.put("response", productDaoImpl.findProduct("name", query));
        }

        return result;
    }

    public Map<Object, Object> create(ProductDto product) {

        Map<Object, Object> result = new HashMap<>();

        if (product == null || product.getName() == null || product.getPrice() == null || product.getQuantity() == null || product.getCategory() == null) {

            result.put("statusCode", 400);
            result.put("response", "All product data is required");
        } else if (productDaoImpl.exist("name", product.getName()) != null) {
            result.put("statusCode", 400);
            result.put("response", "This name of product is already registered.");
        } else {
            result.put("statusCode", 200);
            result.put("response", productDaoImpl.create(product));
        }

        return result;
    }

    public Map<Object, Object> update(String id, ProductDto product) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null || product == null || product.getName() == null || product.getPrice() == null || product.getQuantity() == null || product.getCategory() == null) {

            result.put("statusCode", 400);
            result.put("response", "All product data is required");
        } else {

            Integer productId = ParserUtil.stringToInteger(id);

            product.setId(productId);

            result.put("statusCode", 200);
            result.put("response", productDaoImpl.update(product));
        }

        return result;
    }

    public Map<Object, Object> delete(String id) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null) {

            result.put("statusCode", 400);
            result.put("response", "The product ID can not be empty");
        } else {

            Integer productId = ParserUtil.stringToInteger(id);
            ProductDto originalProduct = getProduct(productId);

            if (originalProduct == null) {
                result.put("statusCode", 404);
                result.put("response", "Product not found");
            } else {

                productDaoImpl.delete(originalProduct);

                result.put("statusCode", 200);
                result.put("response", "Product deleted");
            }
        }

        return result;

    }

    public ProductDto getProduct(Integer id) {
        return productDaoImpl.getProduct(id);
    }
}
