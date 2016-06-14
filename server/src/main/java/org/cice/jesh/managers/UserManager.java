package org.cice.jesh.managers;


import org.cice.jesh.persistence.dao.impl.UserDaoImpl;
import org.cice.jesh.persistence.entities.UserDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by toni on 20/04/16.
 */
public class UserManager {

    UserDaoImpl userDaoImpl = new UserDaoImpl();

    public UserManager() {

    }

    public List<UserDto> getAllUsers() {
        return userDaoImpl.findAll();
    }

    public Map<Object, Object> create(UserDto user) {

        Map<Object, Object> result = new HashMap<>();

        if (user == null || user.getName() == null || user.getSurname() == null || user.getEmail() == null || user.getAddress() == null || user.getbankAccount() == null || user.getPassword() == null) {

            result.put("statusCode", 400);
            result.put("response", "All user data is required");
        } else if(userDaoImpl.exist("email", user.getEmail())){
            result.put("statusCode", 400);
            result.put("response", "This email is already registered.");
        } else {
            result.put("statusCode", 200);
            result.put("response", userDaoImpl.create(user));
        }

        return result;
    }

    public Map<Object, Object> update(String id, UserDto user) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null || user == null || user.getName() == null || user.getSurname() == null || user.getEmail() == null || user.getAddress() == null || user.getbankAccount() == null) {

            result.put("statusCode", 400);
            result.put("response", "All user data is required, except password");
        } else {

            try {
                user.setId(Integer.parseInt(id));
            } catch (NumberFormatException e) {
                throw new Exception(e.toString());
            }



            user.setEmail(null);

            result.put("statusCode", 200);
            result.put("response", userDaoImpl.update(id, user));
       }

        return result;
    }
}
