package org.cice.jesh.managers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.cice.jesh.persistence.dao.impl.OrderDaoImpl;
import org.cice.jesh.persistence.entities.OrderDto;
import org.cice.jesh.persistence.entities.OrderDto;
import org.cice.jesh.utils.ParserUtil;

/**
 * Created by toni on 20/04/16.
 */
public class OrderManager {
    
    OrderDaoImpl orderDaoImpl = new OrderDaoImpl();

    public OrderManager() {

    }

    public Map<Object, Object> getAllOrders() {

        Map<Object, Object> result = new HashMap<>();

        List<OrderDto> ordersList = orderDaoImpl.findAll();
        
        result.put("statusCode", 200);
        result.put("response", ordersList);

        return result;
    }
    
    public Map<Object, Object> getOrder(String id) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null) {

            result.put("statusCode", 400);
            result.put("response", "The order ID can not be empty");
        } else {
            
            Integer orderId = ParserUtil.stringToInteger(id);
            OrderDto originalOrder = getOrderById(orderId);
            
            if (originalOrder == null) {
                result.put("statusCode", 404);
                result.put("response", "Order not found");
            } else {
                result.put("statusCode", 200);
                result.put("response", originalOrder);
            }
        }

        return result;
    }

    public Map<Object, Object> create(OrderDto order) {

        Map<Object, Object> result = new HashMap<>();
        
        result.put("statusCode", 200);
        result.put("response", orderDaoImpl.create(order));

        return result;
    }

    public Map<Object, Object> update(String id, OrderDto order) throws Exception {

        Map<Object, Object> result = new HashMap<>();       
            
        result.put("statusCode", 200);
        result.put("response", orderDaoImpl.update(order));

        return result;
    }
    
    public OrderDto getOrderById(Integer id) {
        return orderDaoImpl.getOrder(id);
    }
}
