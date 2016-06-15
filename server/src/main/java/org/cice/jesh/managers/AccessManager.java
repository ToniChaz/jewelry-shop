package org.cice.jesh.managers;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Toni
 */
public class AccessManager {

    public AccessManager() {
    }
    
    public Map<Object, Object> login() {

        Map<Object, Object> result = new HashMap<>();

        result.put("statusCode", 200);
        result.put("response", "");

        return result;
    } 
    
    public Map<Object, Object> logout() {

        Map<Object, Object> result = new HashMap<>();

        result.put("statusCode", 200);
        result.put("response", "");

        return result;
    }
    
}
