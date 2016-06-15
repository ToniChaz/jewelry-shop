package org.cice.jesh.managers;

import org.cice.jesh.persistence.dao.impl.UserDaoImpl;
import org.cice.jesh.persistence.entities.UserDto;
import org.cice.jesh.utils.ParserUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by toni on 20/04/16.
 */
public class UserManager {

    UserDaoImpl userDaoImpl = new UserDaoImpl();

    public UserManager() {

    }

    public Map<Object, Object> getAllUsers() {

        Map<Object, Object> result = new HashMap<>();

        result.put("statusCode", 200);
        result.put("response", userDaoImpl.findAll());

        return result;
    }

    public Map<Object, Object> getUser(String id) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null) {

            result.put("statusCode", 400);
            result.put("response", "The user ID can not be empty");
        } else {
            
            Integer userId = ParserUtil.stringToInteger(id);
            UserDto originalUser = getUser(userId);
            
            if (originalUser == null) {
                result.put("statusCode", 404);
                result.put("response", "User not found");
            } else {
                result.put("statusCode", 200);
                result.put("response", originalUser);
            }
        }

        return result;
    }

    public Map<Object, Object> create(UserDto user) {

        Map<Object, Object> result = new HashMap<>();

        if (user == null || user.getName() == null || user.getSurname() == null || user.getEmail() == null || user.getAddress() == null || user.getbankAccount() == null || user.getPassword() == null) {

            result.put("statusCode", 400);
            result.put("response", "All user data is required");
        } else if (userDaoImpl.exist("email", user.getEmail())) {
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
            
            Integer userId = ParserUtil.stringToInteger(id);
            
            if(user.getPassword() == null){
                UserDto originalUser = getUser(userId);
                user.setPassword(originalUser.getPassword());
            }
            
            user.setId(userId);
            
            result.put("statusCode", 200);
            result.put("response", userDaoImpl.update(user));
        }

        return result;
    }
    
    public Map<Object, Object> delete(String id) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null) {

            result.put("statusCode", 400);
            result.put("response", "The user ID can not be empty");
        } else {
            
            Integer userId = ParserUtil.stringToInteger(id);
            UserDto originalUser = getUser(userId);
            
            if (originalUser == null) {
                result.put("statusCode", 404);
                result.put("response", "User not found");
            } else {
                
                userDaoImpl.delete(originalUser);
                
                result.put("statusCode", 200);
                result.put("response", "User deleted");
            }
        }

        return result;
        
    }
    
    public UserDto getUser(Integer id){    
        return userDaoImpl.getUser(id);
    }
}
