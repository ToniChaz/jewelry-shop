package org.cice.jesh.managers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.cice.jesh.persistence.dao.impl.AdministratorDaoImpl;
import org.cice.jesh.persistence.dao.impl.TokenDaoImpl;
import org.cice.jesh.persistence.dao.impl.UserDaoImpl;
import org.cice.jesh.persistence.entities.AdministratorDto;
import org.cice.jesh.persistence.entities.LoginCredentials;
import org.cice.jesh.persistence.entities.TokenDto;
import org.cice.jesh.persistence.entities.UserDto;

/**
 *
 * @author Toni
 */
public class AccessManager {

    UserDaoImpl userDaoImpl = new UserDaoImpl();
    AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
    TokenDaoImpl tokenDaoImpl = new TokenDaoImpl();

    public AccessManager() {
    }

    public Map<Object, Object> login(LoginCredentials loginCredentials) {

        Map<Object, Object> result = new HashMap<>();

        if (loginCredentials == null || loginCredentials.getEmail() == null || loginCredentials.getPassword() == null) {
            result.put("statusCode", 400);
            result.put("response", "Email and password is required");
        } else {

            UserDto currentUser = userDaoImpl.exist("email", loginCredentials.getEmail());
            AdministratorDto currentAdministrator = administratorDaoImpl.exist("email", loginCredentials.getEmail());

            if (currentUser == null && currentAdministrator == null) {
                result.put("statusCode", 404);
                result.put("response", "User not exist.");
            } else if (currentAdministrator != null && currentAdministrator.getPassword().equals(loginCredentials.getPassword())) {
                
                Map<String, Object> response = new HashMap<>();

                final boolean isLogged = true;
                final boolean isAdministrator = true;

                currentAdministrator.setLastConnection();
                administratorDaoImpl.update(currentAdministrator);

                response.put("isLogged", isLogged);
                response.put("isAdministrator", isAdministrator);
                response.put("userId", currentAdministrator.getId());
                response.put("accessToken", generateAccessToken(currentAdministrator.getId()));

                
                result.put("statusCode", 200);
                result.put("response", response);                
                
            } else if (currentUser != null && currentUser.getPassword().equals(loginCredentials.getPassword())) {

                Map<String, Object> response = new HashMap<>();

                final boolean isLogged = true;
                final boolean isAdministrator = false;

                response.put("isLogged", isLogged);
                response.put("isAdministrator", isAdministrator);
                response.put("userId", currentUser.getId());
                response.put("accessToken", generateAccessToken(currentUser.getId()));
                
                result.put("statusCode", 200);
                result.put("response", response);
                
            } else {
                result.put("statusCode", 403);
                result.put("response", "Forbidden");
            }

        }
        return result;
    }

    public Map<Object, Object> logout(String accessToken) {

        Map<Object, Object> result = new HashMap<>();
        Map<String, Boolean> response = new HashMap<>();

        response.put("isLogged", deleteToken(accessToken));
        
        result.put("statusCode", 200);
        result.put("response", response);

        return result;
    }
    
    private boolean deleteToken(String accessToken){
        
        TokenDto validToken = tokenDaoImpl.validToken("token", accessToken);
        
        validToken.setToken("");
        tokenDaoImpl.update(validToken);
        
        return false;
    }

    private String generateAccessToken(Integer id) {
        
        TokenDto existToken = tokenDaoImpl.exist("user_id", id);
        String token = UUID.randomUUID().toString();


        if (existToken == null) {
            TokenDto newToken = new TokenDto();
            newToken.setUserId(id);
            newToken.setToken(token);
            tokenDaoImpl.create(newToken);
        } else {
            existToken.setToken(token);
            tokenDaoImpl.update(existToken);
        }
        
        return token;
    }
}
