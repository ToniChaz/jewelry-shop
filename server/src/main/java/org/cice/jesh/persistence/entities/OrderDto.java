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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "orders_product",
            joinColumns = {
                    @JoinColumn(name = "orders_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "product_id")})
    private List<ProductDto> orderProducts;

    public OrderDto() {
    }

    public OrderDto(int orderId, int userId, List<ProductDto> orderProducts) {
        this.orderId = orderId;
        this.userId = userId;
        this.date = setOrderDate();
        this.total = calculateTotal();
        this.orderProducts = orderProducts;
    }

    public OrderDto(int userId, List<ProductDto> orderProducts) {
        this.userId = userId;
        this.date = setOrderDate();
        this.total = calculateTotal();
        this.orderProducts = orderProducts;
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
        return orderProducts;
    }

    public void setProductsList(List<ProductDto> orderProducts) {
        this.orderProducts = orderProducts;
    }

    private Date setOrderDate() {
        return new Date();
    }

    private double calculateTotal() {

        double result = 0.0;

        for (ProductDto product : this.orderProducts) {
            result += product.getPrice();
        }

        return result;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", date=" + date +
                ", total=" + total +
                ", orderProducts=" + orderProducts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDto)) return false;

        OrderDto orderDto = (OrderDto) o;

        if (getOrderId() != orderDto.getOrderId()) return false;
        if (getUserId() != orderDto.getUserId()) return false;
        if (Double.compare(orderDto.getTotal(), getTotal()) != 0) return false;
        if (!getDate().equals(orderDto.getDate())) return false;
        return orderProducts.equals(orderDto.orderProducts);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getOrderId();
        result = 31 * result + getUserId();
        result = 31 * result + getDate().hashCode();
        temp = Double.doubleToLongBits(getTotal());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + orderProducts.hashCode();
        return result;
    }
}
