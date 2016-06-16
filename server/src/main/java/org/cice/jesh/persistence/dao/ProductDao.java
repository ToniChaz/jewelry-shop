package org.cice.jesh.persistence.dao;

import java.util.List;
import org.cice.jesh.persistence.entities.ProductDto;

/**
 * Created by toni on 20/04/16.
 */
public interface ProductDao {
    
    List<ProductDto> findAll();

    ProductDto getProduct(Integer productId);
    
    List<ProductDto> findProduct(String columnToSearch, String valueToSearch);

    ProductDto create(ProductDto product);

    ProductDto update(ProductDto product);

    void delete(ProductDto product);
    
    ProductDto exist(String columnToSearch, String valueToSearch);

}
