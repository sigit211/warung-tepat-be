package org.shifted.entity.request;

import org.shifted.entity.product.ProductStockUpdate;
import org.shifted.entity.transaction.TransactionDAO;

import java.util.List;

public class CheckoutRequest {

    private TransactionDAO transaction;
    private List<ProductStockUpdate> products;

    public CheckoutRequest(TransactionDAO transaction, List<ProductStockUpdate> products) {
        this.transaction = transaction;
        this.products = products;
    }

    public TransactionDAO getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionDAO transaction) {
        this.transaction = transaction;
    }

    public List<ProductStockUpdate> getProducts() {
        return products;
    }

    public void setProducts(List<ProductStockUpdate> products) {
        this.products = products;
    }
}
