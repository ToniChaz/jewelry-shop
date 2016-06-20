package org.cice.jesh.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Created by toni on 20/04/16.
 */
@Entity
@Table(name = "product")
public class ProductDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "category")
    private String category;
    
    @ManyToMany(mappedBy="productsList")
    private List<OrderDto> ordersList;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, Double price, Integer quantity, String category, List<OrderDto> ordersList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.ordersList = ordersList;
    }

    public ProductDto(String name, Double price, Integer quantity, String category, List<OrderDto> ordersList) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.ordersList = ordersList;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<OrderDto> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<OrderDto> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return "ProductDto{" + "id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", category=" + category + ", ordersList=" + ordersList + '}';
    }

}
