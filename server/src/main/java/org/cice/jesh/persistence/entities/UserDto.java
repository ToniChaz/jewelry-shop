package org.cice.jesh.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by toni on 20/04/16.
 */
@Entity
@Table(name = "user")
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "bank_account")
    private String bankAccount;
    @Column(name = "address")
    private String address;
    @Column(name = "password")
    private String password;

    @Transient
    private List<OrderDto> orders;


    public UserDto() {
    }

    public UserDto(Integer id, String name, String surname, String email, String bankAccount, String address, String password, List<OrderDto> orders) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.bankAccount = bankAccount;
        this.address = address;
        this.password = password;
        this.orders = orders;
    }

    public UserDto(String name, String surname, String email, String bankAccount, String address, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.bankAccount = bankAccount;
        this.address = address;
        this.password = password;
    }

    public UserDto(String name, String surname, String email, String bankAccount, String address, String password, List<OrderDto> orders) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.bankAccount = bankAccount;
        this.address = address;
        this.password = password;
        this.orders = orders;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "UserDto{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", bankAccount=" + bankAccount + ", address=" + address + ", password=" + password + '}';
    }

}
