package org.cice.jesh.persistence.dao;

import java.util.List;
import org.cice.jesh.persistence.entities.OrderDto;

/**
 * Created by toni on 20/04/16.
 */
public interface OrderDao {
    
    List<OrderDto> findAll();

    OrderDto getOrder(Integer orderId);

    OrderDto create(OrderDto order);

    OrderDto update(OrderDto order);

    void delete(OrderDto order);

    OrderDto exist(String columnToSearch, String valueToSearch);
}
