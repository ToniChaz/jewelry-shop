package org.cice.jesh.persistence.dao.impl;

import java.util.List;
import javax.inject.Inject;
import org.cice.jesh.persistence.dao.AbstractFactory;
import org.cice.jesh.persistence.dao.AdministratorDao;
import org.cice.jesh.persistence.entities.AdministratorDto;

/**
 * Created by toni on 20/04/16.
 */
public class AdministratorDaoImpl extends AbstractFactory<AdministratorDto> implements AdministratorDao {
    
    @Inject
    public AdministratorDaoImpl() {
        super(AdministratorDto.class);
    }

    @Override
    public List<AdministratorDto> findAll() {
        return super.findAll();
    }

    @Override
    public AdministratorDto getAdministrator(Integer administratorId) {
        return super.get(administratorId);
    }

    @Override
    public AdministratorDto create(AdministratorDto administrator) {
        return super.create(administrator);
    }

    @Override
    public AdministratorDto update(AdministratorDto administrator) {
        return super.update(administrator);
    }

    @Override
    public void delete(AdministratorDto administrator) {
       super.delete(administrator);
    }

    @Override
    public AdministratorDto exist(String columnToSearch, String valueToSearch) {
        return super.findByColumnName(columnToSearch, valueToSearch);
    }
}
