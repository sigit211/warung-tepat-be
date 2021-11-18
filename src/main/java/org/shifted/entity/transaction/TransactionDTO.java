package org.shifted.entity.transaction;

import org.shifted.entity.product.ProductInCartDTO;

import java.util.List;

public class TransactionDTO {

    private long transaction_id;

    private String user_id;

    private String transaction_date;

    private String ref_code;

    private int transaction_amount;

    private String transaction_status;

    private List<ProductInCartDTO> products;

    public TransactionDTO(long transaction_id, String user_id, String transaction_date, String ref_code, int transaction_amount, String transaction_status, List<ProductInCartDTO> products) {
        this.transaction_id = transaction_id;
        this.user_id = user_id;
        this.transaction_date = transaction_date;
        this.ref_code = ref_code;
        this.transaction_amount = transaction_amount;
        this.transaction_status = transaction_status;
        this.products = products;
    }

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

    public List<ProductInCartDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInCartDTO> products) {
        this.products = products;
    }
}
