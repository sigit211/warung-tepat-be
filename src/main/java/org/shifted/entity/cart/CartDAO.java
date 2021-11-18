package org.shifted.entity.cart;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class CartDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cart_id;

    @Column
    private String user_id;

    @Column
    private String cart_status = "Active";

    public long getCart_id() {
        return cart_id;
    }

    public void setCart_id(long cart_id) {
        this.cart_id = cart_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCart_status() {
        return cart_status;
    }

    public void setCart_status(String cart_status) {
        this.cart_status = cart_status;
    }
}
