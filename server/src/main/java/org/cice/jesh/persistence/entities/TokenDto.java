/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cice.jesh.persistence.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Toni
 */
@Entity
@Table(name = "token")
public class TokenDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "token")
    private String token;

    public TokenDto() {
    }

    public TokenDto(Integer id, Integer userId, String token) {
        this.id = id;
        this.userId = userId;
        this.token = token;
    }

    public TokenDto(Integer userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    @Override
    public String toString() {
        return "TokenDto{" + "id=" + id + ", userId=" + userId + ", token=" + token + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokenDto)) return false;

        TokenDto tokenDto = (TokenDto) o;

        if (!getId().equals(tokenDto.getId())) return false;
        if (!getUserId().equals(tokenDto.getUserId())) return false;
        return getToken().equals(tokenDto.getToken());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getUserId().hashCode();
        result = 31 * result + getToken().hashCode();
        return result;
    }
}
