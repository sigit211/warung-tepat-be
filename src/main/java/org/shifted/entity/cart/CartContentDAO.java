package org.shifted.entity.cart;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.shifted.entity.product.ProductDAO;

import javax.persistence.*;

@Entity
@Table(name = "cart_contents")
public class CartContentDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", updatable = false)
    @Fetch(FetchMode.JOIN)
    private CartDAO cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @Fetch(FetchMode.JOIN)
    private ProductDAO product;

    @Column
    private int product_incart_qty;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CartDAO getCart() {
        return cart;
    }

    public void setCart(CartDAO cart) {
        this.cart = cart;
    }

    public ProductDAO getProduct() {
        return product;
    }

    public void setProduct(ProductDAO product) {
        this.product = product;
    }

    public int getProduct_incart_qty() {
        return product_incart_qty;
    }

    public void setProduct_incart_qty(int product_incart_qty) {
        this.product_incart_qty = product_incart_qty;
    }
}
