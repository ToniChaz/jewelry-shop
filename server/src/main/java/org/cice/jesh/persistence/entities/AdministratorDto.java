package org.cice.jesh.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by toni on 20/04/16.
 */

@Entity
@Table(name = "administrator")
public class AdministratorDto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "administrator_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "last_connection")
    private Date lastConnection;


    public AdministratorDto() {
    }

    public AdministratorDto(Integer id, String name, String surname, String email, String password, Date lastConnection) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.lastConnection = lastConnection;
    }

    public AdministratorDto(String name, String surname, String email, String password, Date lastConnection) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.lastConnection = lastConnection;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public Date getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection() {
        this.lastConnection = new Date();
    }

    @Override
    public String toString() {
        return "AdministratorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lastConnection=" + lastConnection +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdministratorDto)) return false;

        AdministratorDto that = (AdministratorDto) o;

        if (!getId().equals(that.getId())) return false;
        if (!getName().equals(that.getName())) return false;
        if (!getSurname().equals(that.getSurname())) return false;
        if (!getEmail().equals(that.getEmail())) return false;
        if (!getPassword().equals(that.getPassword())) return false;
        return getLastConnection().equals(that.getLastConnection());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getLastConnection().hashCode();
        return result;
    }
}
