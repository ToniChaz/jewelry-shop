package org.cice.jesh.managers;

import org.cice.jesh.persistence.dao.impl.UserDaoImpl;
import org.cice.jesh.persistence.entities.UserDto;

import java.util.List;

/**
 * Created by toni on 20/04/16.
 */
public class UserManager {

    UserDaoImpl userDaoImpl = new UserDaoImpl();

    public UserManager() {
    }

    public List<UserDto> getAllUsers(){
        return userDaoImpl.findAll();
    }

    public UserDto create(UserDto user){

        return userDaoImpl.create(user);
    }
}
