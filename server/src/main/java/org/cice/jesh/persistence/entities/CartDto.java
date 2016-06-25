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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "cart_product",
            joinColumns = {
                    @JoinColumn(name = "cart_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "product_id")})
    private List<ProductDto> cartProducts;

    public CartDto() {
    }

    public CartDto(List<ProductDto> cartProducts, int userId) {
        this.cartProducts = cartProducts;
        this.userId = userId;
        this.total = calculateTotal();
    }

    public CartDto(List<ProductDto> cartProducts) {
        this.total = calculateTotal();
        this.cartProducts = cartProducts;
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
        return cartProducts;
    }

    public void setProductsList(List<ProductDto> cartProducts) {
        this.cartProducts = cartProducts;
    }

    private double calculateTotal(){

        double result = 0.0;

        for(ProductDto product: this.cartProducts){
            result += product.getPrice();
        }

        return result;
    }

    public void addProduct(ProductDto product){
        this.cartProducts.add(product);
    }

    public boolean removeProduct(ProductDto productToRemove){
        return this.cartProducts.remove(productToRemove);
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", total=" + total +
                ", products=" + cartProducts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartDto)) return false;

        CartDto cartDto = (CartDto) o;

        if (getCartId() != cartDto.getCartId()) return false;
        if (getUserId() != cartDto.getUserId()) return false;
        if (Double.compare(cartDto.getTotal(), getTotal()) != 0) return false;
        return cartProducts.equals(cartDto.cartProducts);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getCartId();
        result = 31 * result + getUserId();
        temp = Double.doubleToLongBits(getTotal());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cartProducts.hashCode();
        return result;
    }
}
