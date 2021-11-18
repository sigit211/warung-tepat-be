package org.shifted.entity.transaction;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.shifted.entity.cart.CartDAO;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transaction_id;

    @Column
    private String user_id;

    @Column
    private String transaction_date;

    @Column
    private String ref_code;

    @Column
    private int transaction_amount;

    @Column
    private String transaction_status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    @Fetch(FetchMode.JOIN)
    private CartDAO cart;

    public long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getRef_code() {
        return ref_code;
    }

    public void setRef_code(String ref_code) {
        this.ref_code = ref_code;
    }

    public int getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(int transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTransaction_status() {
        return transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    public CartDAO getCart() {
        return cart;
    }

    public void setCart(CartDAO cart) {
        this.cart = cart;
    }
}
