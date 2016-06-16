package org.cice.jesh.persistence.dao;

import java.util.List;
import org.cice.jesh.persistence.entities.AdministratorDto;

/**
 * Created by toni on 20/04/16.
 */
public interface AdministratorDao {
    
    List<AdministratorDto> findAll();

    AdministratorDto getAdministrator(Integer administratorId);

    AdministratorDto create(AdministratorDto administrator);

    AdministratorDto update(AdministratorDto administrator);

    void delete(AdministratorDto administrator);

    AdministratorDto exist(String columnToSearch, String valueToSearch);
}
