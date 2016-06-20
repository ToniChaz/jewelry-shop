package org.cice.jesh.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Created by toni on 20/04/16.
 */
@Entity
@Table(name = "order")
@Access(value = AccessType.FIELD)
public class OrderDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "date")
    private Date date;
    @Column(name = "total")
    private double total;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "order_product",
            joinColumns = {
                @JoinColumn(name = "order_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "product_id")})
    private List<ProductDto> productsList;

    public OrderDto() {
    }

    public OrderDto(int orderId, int userId, Date date, double total, List<ProductDto> productsList) {
        this.orderId = orderId;
        this.userId = userId;
        this.date = date;
        this.total = total;
        this.productsList = productsList;
    }

    public OrderDto(int userId, Date date, double total, List<ProductDto> productsList) {
        this.userId = userId;
        this.date = date;
        this.total = total;
        this.productsList = productsList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<ProductDto> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<ProductDto> productsList) {
        this.productsList = productsList;
    }

    @Override
    public String toString() {
        return "OrderDto{" + "orderId=" + orderId + ", userId=" + userId + ", date=" + date + ", total=" + total + ", productsList=" + productsList + '}';
    }
    
    

}
