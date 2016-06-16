package org.cice.jesh.persistence.dao;

import org.cice.jesh.persistence.entities.TokenDto;

/**
 *
 * @author Toni
 */
public interface TokenDao {

    TokenDto getToken(Integer tokenId);

    TokenDto create(TokenDto token);

    TokenDto update(TokenDto token);
    
    TokenDto exist(String columnToSearch, int valueToSearch);
    
    TokenDto validToken(String columnToSearch, String valueToSearch);
}
