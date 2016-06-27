package org.cice.jesh.persistence.dao;

import java.util.List;
import org.cice.jesh.persistence.entities.OrderDto;

/**
 * Created by toni on 20/04/16.
 */
public interface OrderDao {
    
    List<OrderDto> findAll(String columnToSearch, int valueToSearch);

    OrderDto create(OrderDto order);

    List<Object[]> findTop(String table, String column, int limit);
}
