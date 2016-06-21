package org.cice.jesh.persistence.dao.impl;

import java.util.List;
import javax.inject.Inject;
import org.cice.jesh.persistence.dao.AbstractFactory;
import org.cice.jesh.persistence.dao.ProductDao;
import org.cice.jesh.persistence.entities.ProductDto;

/**
 * Created by toni on 20/04/16.
 */
public class ProductDaoImpl extends AbstractFactory<ProductDto> implements ProductDao {

    @Inject
    public ProductDaoImpl() {
        super(ProductDto.class);
    }

    @Override
    public List<ProductDto> findAll() {
        return super.findAll();
    }

    @Override
    public ProductDto getProduct(Integer productId) {
        return super.get(productId);
    }
    
    @Override
    public List<ProductDto> findProduct(String columnToSearch, String valueToSearch) {
        return super.findListByString(columnToSearch, valueToSearch);
    }

    @Override
    public ProductDto create(ProductDto product) {
        return super.create(product);
    }

    @Override
    public ProductDto update(ProductDto product) {
        return super.update(product);
    }

    @Override
    public void delete(ProductDto product) {
       super.delete(product);
    }
    
    @Override
    public ProductDto exist(String columnToSearch, String valueToSearch) {
        return super.findByColumnName(columnToSearch, valueToSearch);
    }
    
}
