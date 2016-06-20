package org.cice.jesh.persistence.dao.impl;

import java.util.List;
import javax.inject.Inject;
import org.cice.jesh.persistence.dao.AbstractFactory;
import org.cice.jesh.persistence.dao.OrderDao;
import org.cice.jesh.persistence.entities.OrderDto;

/**
 * Created by toni on 20/04/16.
 */
public class OrderDaoImpl extends AbstractFactory<OrderDto> implements OrderDao {

    @Inject
    public OrderDaoImpl() {
        super(OrderDto.class);
    }

    @Override
    public List<OrderDto> findAll() {
        return super.findAll();
    }

    @Override
    public OrderDto getOrder(Integer orderId) {
        return super.get(orderId);
    }

    @Override
    public OrderDto create(OrderDto order) {
        return super.create(order);
    }

    @Override
    public OrderDto update(OrderDto order) {
        return super.update(order);
    }

    @Override
    public void delete(OrderDto order) {
       super.delete(order);
    }

    @Override
    public OrderDto exist(String columnToSearch, String valueToSearch) {
        return super.findByColumnName(columnToSearch, valueToSearch);
    }
}
