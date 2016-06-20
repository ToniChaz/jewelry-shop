package org.cice.jesh.persistence.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by toni on 20/04/16.
 */
@Entity
@Table(name = "cart")
@Access(value= AccessType.FIELD)
public class CartDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer cartId;

    @Column(name = "total")
    private Double total;

    public CartDto() {
    }

    public CartDto(Integer cartId, Double total) {
        this.cartId = cartId;
        this.total = total;
    }

    public CartDto(Double total) {
        this.total = total;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CartDto{" + "cartId=" + cartId + ", total=" + total + '}';
    }    
    
}
