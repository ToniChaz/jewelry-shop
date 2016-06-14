package org.cice.jesh.persistence.dao.impl;

import org.cice.jesh.persistence.dao.AbstractFactory;
import org.cice.jesh.persistence.dao.UserDao;
import org.cice.jesh.persistence.entities.UserDto;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by toni on 20/04/16.
 */
public class UserDaoImpl extends AbstractFactory<UserDto> implements UserDao {

    @Inject
    public UserDaoImpl() {
        super(UserDto.class);
    }

    @Override
    public List<UserDto> findAll() {
        return super.findAll();
    }

    @Override
    public UserDto getUser(Integer userId) {
        return super.get(userId);
    }

    @Override
    public UserDto create(UserDto user) {
        return super.create(user);
    }

    @Override
    public UserDto update(String id, UserDto user) {
        return super.update(id, user);
    }

    @Override
    public void delete(Integer userId) {
        super.delete(userId);
    }

    @Override
    public boolean exist(String columnToSearch, String valueToSearch) {
        return super.checkIfExist(columnToSearch, valueToSearch);
    }
}
