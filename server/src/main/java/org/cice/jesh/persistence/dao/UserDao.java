package org.cice.jesh.persistence.dao;

import org.cice.jesh.persistence.entities.UserDto;

import java.util.List;

/**
 * Created by toni on 20/04/16.
 */
public interface UserDao {

    List<UserDto> findAll();

    UserDto getUser(Integer userId);

    UserDto create(UserDto user);

    UserDto update(String id, UserDto user);

    void delete(Integer userId);

    boolean exist(String columnToSearch, String valueToSearch);
}
