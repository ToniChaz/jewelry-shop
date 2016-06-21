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

    public List<OrderDto> getAllOrders(int userId) throws Exception {
        return orderDaoImpl.findAll("user_id", userId);
    }

    public OrderDto create(OrderDto order) {
        return orderDaoImpl.create(order);
    }
}
