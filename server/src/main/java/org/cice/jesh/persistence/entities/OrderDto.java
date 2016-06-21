package org.cice.jesh.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Created by toni on 20/04/16.
 */
@Entity
@Table(name = "orders")
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "orders_product",
            joinColumns = {
                @JoinColumn(name = "orders_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "product_id")})
    private List<ProductDto> products;

    public OrderDto() {
    }

    public OrderDto(int orderId, int userId, List<ProductDto> products) {
        this.orderId = orderId;
        this.userId = userId;
        this.date = setOrderDate();
        this.total = calculateTotal();
        this.products = products;
    }

    public OrderDto(int userId, List<ProductDto> products) {
        this.userId = userId;
        this.date = setOrderDate();
        this.total = calculateTotal();
        this.products = products;
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

    public void setDate() {
        this.date = setOrderDate();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = calculateTotal();
    }

    public List<ProductDto> getProductsList() {
        return products;
    }

    public void setProductsList(List<ProductDto> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderDto{" + "orderId=" + orderId + ", userId=" + userId + ", date=" + date + ", total=" + total + ", products=" + products + '}';
    }
    
    private Date setOrderDate(){
        return new Date();
    }

    private double calculateTotal(){

        double result = 0.0;

        for(ProductDto product: this.products){
            result += product.getPrice();
        }

        return result;
    }

}
