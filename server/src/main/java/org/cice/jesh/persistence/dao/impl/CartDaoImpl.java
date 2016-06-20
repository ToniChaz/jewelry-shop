package org.cice.jesh.persistence.dao.impl;

import org.cice.jesh.persistence.dao.AbstractFactory;
import org.cice.jesh.persistence.dao.CartDao;
import org.cice.jesh.persistence.entities.CartDto;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by toni on 20/04/16.
 */
public class CartDaoImpl extends AbstractFactory<CartDto> implements CartDao {

    @Inject
    public CartDaoImpl() {
        super(CartDto.class);
    }

    @Override
    public CartDto getCart(Integer cartId) {
        return super.get(cartId);
    }

    @Override
    public CartDto create(CartDto cart) {
        return super.create(cart);
    }

    @Override
    public CartDto update(CartDto cart) {
        return super.update(cart);
    }

    @Override
    public void delete(CartDto cart) {
        super.delete(cart);
    }

    @Override
    public CartDto exist(String columnToSearch, String valueToSearch) {
        return super.findByColumnName(columnToSearch, valueToSearch);
    }

    @Override
    public CartDto getCartByUserId(String columnToSearch, int valueToSearch) {
        return super.findByColumnName(columnToSearch, valueToSearch);
    }

}
