package org.cice.jesh.persistence.dao;

import org.cice.jesh.persistence.entities.CartDto;

import java.util.List;

/**
 * Created by toni on 20/04/16.
 */
public interface CartDao {

    CartDto getCart(Integer cartId);

    CartDto create(CartDto cart);

    CartDto update(CartDto cart);

    void delete(CartDto cart);

    CartDto exist(String columnToSearch, String valueToSearch);

    CartDto getCartByUserId(String columnToSearch, int valueToSearch);
}
