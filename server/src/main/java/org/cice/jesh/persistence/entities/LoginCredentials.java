package org.cice.jesh.persistence.entities;

import java.io.Serializable;

/**
 *
 * @author Toni
 */
public class LoginCredentials implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String email;
    private String password;
    
    public LoginCredentials() {
    }

    public LoginCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginCredentials{" + "email=" + email + ", password=" + password + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginCredentials)) return false;

        LoginCredentials that = (LoginCredentials) o;

        if (!getEmail().equals(that.getEmail())) return false;
        return getPassword().equals(that.getPassword());

    }

    @Override
    public int hashCode() {
        int result = getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}
