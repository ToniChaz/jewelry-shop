package org.cice.jesh.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Created by toni on 20/04/16.
 */
@Entity
@Table(name = "cart")
@Access(value = AccessType.FIELD)
public class CartDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private int cartId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "total")
    private double total;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "cart_product",
            joinColumns = {
                    @JoinColumn(name = "cart_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "product_id")})
    private List<ProductDto> products;

    public CartDto() {
    }

    public CartDto(List<ProductDto> products, int userId) {
        this.products = products;
        this.userId = userId;
        this.total = calculateTotal();
    }

    public CartDto(List<ProductDto> products) {
        this.total = calculateTotal();
        this.products = products;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        return "CartDto{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", total=" + total +
                ", products=" + products +
                '}';
    }

    private double calculateTotal(){

        double result = 0.0;

        for(ProductDto product: this.products){
            result += product.getPrice();
        }

        return result;
    }

    public void addProduct(ProductDto product){
        this.products.add(product);
    }

    public void removeProduct(ProductDto productToRemove){
        List<ProductDto> productsList = this.products;
        for (int i = 0; i < productsList.size(); i++) {
            ProductDto product = productsList.get(i);
            if (productToRemove.getId().equals(product.getId())) {
                this.products.remove(productToRemove);
            }
        }
    }

}
