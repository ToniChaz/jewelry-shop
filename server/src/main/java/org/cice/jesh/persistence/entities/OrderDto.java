package org.cice.jesh.persistence.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
/**
 * Created by toni on 20/04/16.
 */
@Entity
@Table(name = "order")
@Access(value= AccessType.FIELD)
public class OrderDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @OneToOne(mappedBy = "order_products")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private ProductDto products;

    public OrderDto(Integer orderId, ProductDto products) {
        this.orderId = orderId;
        this.products = products;
    }

    public OrderDto(ProductDto products) {
        this.products = products;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public ProductDto getProducts() {
        return products;
    }

    public void setProducts(ProductDto products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderDto{" + "orderId=" + orderId + ", products=" + products + '}';
    }
    
    
}