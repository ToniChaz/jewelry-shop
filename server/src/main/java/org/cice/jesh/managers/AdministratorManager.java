package org.cice.jesh.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cice.jesh.persistence.dao.impl.AdministratorDaoImpl;
import org.cice.jesh.persistence.entities.AdministratorDto;
import org.cice.jesh.utils.ParserUtil;

/**
 * Created by toni on 20/04/16.
 */
public class AdministratorManager {

    AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();

    public AdministratorManager() {

    }

    public Map<Object, Object> getAllAdministrators() {

        Map<Object, Object> result = new HashMap<>();

        List<AdministratorDto> administratorsList = administratorDaoImpl.findAll();
        List<AdministratorDto> SecureAdministratorsList = new ArrayList<>();

        if (administratorsList.size() > 0) {
            for (AdministratorDto item : administratorsList) {
                item.setPassword("");
                SecureAdministratorsList.add(item);
            }
            result.put("statusCode", 200);
            result.put("response", SecureAdministratorsList);
        } else {
            result.put("statusCode", 200);
            result.put("response", administratorsList);
        }


        return result;
    }

    public Map<Object, Object> getAdministrator(String id) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null) {

            result.put("statusCode", 400);
            result.put("response", "The administrator ID can not be empty");
        } else {

            Integer administratorId = ParserUtil.stringToInteger(id);
            AdministratorDto originalAdministrator = getAdministrator(administratorId);

            if (originalAdministrator == null) {
                result.put("statusCode", 404);
                result.put("response", "Administrator not found");
            } else {
                originalAdministrator.setPassword("");
                result.put("statusCode", 200);
                result.put("response", originalAdministrator);
            }
        }

        return result;
    }

    public Map<Object, Object> create(AdministratorDto administrator) {

        Map<Object, Object> result = new HashMap<>();

        if (administrator == null || administrator.getName() == null || administrator.getSurname() == null || administrator.getEmail() == null || administrator.getPassword() == null) {

            result.put("statusCode", 400);
            result.put("response", "All administrator data is required");
        } else if (administratorDaoImpl.exist("email", administrator.getEmail()) != null) {
            result.put("statusCode", 400);
            result.put("response", "This email is already registered.");
        } else {
            result.put("statusCode", 200);
            result.put("response", administratorDaoImpl.create(administrator));
        }

        return result;
    }

    public Map<Object, Object> update(String id, AdministratorDto administrator) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null || administrator == null || administrator.getName() == null || administrator.getSurname() == null || administrator.getEmail() == null) {

            result.put("statusCode", 400);
            result.put("response", "All administrator data is required, except password");
        } else {

            Integer administratorId = ParserUtil.stringToInteger(id);

            if (administrator.getPassword() == null) {
                AdministratorDto originalAdministrator = getAdministrator(administratorId);
                administrator.setPassword(originalAdministrator.getPassword());
            }

            administrator.setId(administratorId);

            result.put("statusCode", 200);
            result.put("response", administratorDaoImpl.update(administrator));
        }

        return result;
    }

    public Map<Object, Object> delete(String id) throws Exception {

        Map<Object, Object> result = new HashMap<>();

        if (id == null) {

            result.put("statusCode", 400);
            result.put("response", "The administrator ID can not be empty");
        } else {

            Integer administratorId = ParserUtil.stringToInteger(id);
            AdministratorDto originalAdministrator = getAdministrator(administratorId);

            if (originalAdministrator == null) {
                result.put("statusCode", 404);
                result.put("response", "Administrator not found");
            } else {

                administratorDaoImpl.delete(originalAdministrator);

                result.put("statusCode", 200);
                result.put("response", "Administrator deleted");
            }
        }

        return result;

    }

    public AdministratorDto getAdministrator(Integer id) {
        return administratorDaoImpl.getAdministrator(id);
    }
}
