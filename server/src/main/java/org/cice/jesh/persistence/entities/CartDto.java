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
@Table(name = "cart")
@Access(value= AccessType.FIELD)
public class CartDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer cartId;

    @OneToOne(mappedBy = "cart_products")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private ProductDto products;

    public CartDto(Integer cartId, ProductDto products) {
        this.cartId = cartId;
        this.products = products;
    }

    public CartDto(ProductDto products) {
        this.products = products;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public ProductDto getProducts() {
        return products;
    }

    public void setProducts(ProductDto products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CartDto{" + "cartId=" + cartId + ", products=" + products + '}';
    }
    
    
}
