package org.cice.jesh.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

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

    @Transient
    @ManyToMany(fetch = FetchType.EAGER, mappedBy="orderProducts", cascade = CascadeType.ALL)
    private List<OrderDto> ordersList;

    @Transient
    @ManyToMany(fetch = FetchType.EAGER, mappedBy="cartProducts", cascade = CascadeType.ALL)
    private List<CartDto> cartList;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, Double price, Integer quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public ProductDto(String name, Double price, Integer quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public ProductDto(String name, Double price, Integer quantity, String category, List<OrderDto> ordersList, List<CartDto> cartList) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.ordersList = ordersList;
        this.cartList = cartList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public List<CartDto> getCartList() {
        return cartList;
    }

    public void setCartList(List<CartDto> cartList) {
        this.cartList = cartList;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "category='" + category + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto)) return false;

        ProductDto that = (ProductDto) o;

        if (!getId().equals(that.getId())) return false;
        if (!getName().equals(that.getName())) return false;
        if (!getPrice().equals(that.getPrice())) return false;
        if (!getQuantity().equals(that.getQuantity())) return false;
        return getCategory().equals(that.getCategory());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getQuantity().hashCode();
        result = 31 * result + getCategory().hashCode();
        return result;
    }
}
