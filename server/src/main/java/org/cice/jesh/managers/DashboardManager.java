package org.cice.jesh.managers;

import org.cice.jesh.persistence.dao.impl.AdministratorDaoImpl;
import org.cice.jesh.persistence.dao.impl.OrderDaoImpl;
import org.cice.jesh.persistence.dao.impl.ProductDaoImpl;
import org.cice.jesh.persistence.dao.impl.UserDaoImpl;
import org.cice.jesh.persistence.entities.AdministratorDto;
import org.cice.jesh.persistence.entities.OrderDto;
import org.cice.jesh.persistence.entities.ProductDto;
import org.cice.jesh.persistence.entities.UserDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by toni on 25/06/16.
 */
public class DashboardManager {

    AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
    OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
    UserDaoImpl userDaoImpl = new UserDaoImpl();
    ProductDaoImpl productDaoImpl = new ProductDaoImpl();

    public DashboardManager() {
    }

    public Map<Object, Object> get() {

        Map<Object, Object> result = new HashMap<>();
        Map<String, Object> response = new HashMap<>();

        List<AdministratorDto> listAdministrators = administratorDaoImpl.findAll();
        List<Object[]> topUsersIds = orderDaoImpl.findTop("orders", "user_id", 3);
        List<Object[]> topProductsIds = orderDaoImpl.findTop("orders_product", "product_id", 3);
        List<UserDto> topUsers = new ArrayList<>();
        List<ProductDto> topProducts = new ArrayList<>();

        for(Object[] obj : topUsersIds) {
            Integer id = Integer.valueOf(obj[0].toString());
            topUsers.add(userDaoImpl.getUser(id));
        }

        for(Object[] obj : topProductsIds) {
            Integer id = Integer.valueOf(obj[0].toString());
            topProducts.add(productDaoImpl.getProduct(id));
        }

        response.put("administratorsConnections", listAdministrators);
        response.put("topUsers", topUsers);
        response.put("topProducts", topProducts);

        result.put("statusCode", 200);
        result.put("response", response);

        return result;
    }
}
