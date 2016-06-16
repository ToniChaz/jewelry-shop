package org.cice.jesh.persistence.dao.impl;

import javax.inject.Inject;
import org.cice.jesh.persistence.dao.AbstractFactory;
import org.cice.jesh.persistence.dao.TokenDao;
import org.cice.jesh.persistence.entities.TokenDto;

/**
 *
 * @author Toni
 */
public class TokenDaoImpl extends AbstractFactory<TokenDto> implements TokenDao {

    @Inject
    public TokenDaoImpl() {
        super(TokenDto.class);
    }

    @Override
    public TokenDto getToken(Integer tokenId) {
        return super.get(tokenId);
    }

    @Override
    public TokenDto create(TokenDto token) {
        return super.create(token);
    }

    @Override
    public TokenDto update(TokenDto token) {
        return super.update(token);
    }    

    @Override
    public TokenDto exist(String columnToSearch, int valueToSearch) {
        return super.findByColumnName(columnToSearch, valueToSearch);
    }
    
    @Override
    public TokenDto validToken(String columnToSearch, String valueToSearch) {
        return super.findByColumnName(columnToSearch, valueToSearch);
    }
    
}
