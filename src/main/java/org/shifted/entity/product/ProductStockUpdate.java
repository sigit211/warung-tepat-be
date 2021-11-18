package org.shifted.entity.product;

public class ProductStockUpdate {

    private ProductDAO product;
    private int qty_taken;

    public ProductStockUpdate(ProductDAO product, int qty_taken) {
        this.product = product;
        this.qty_taken = qty_taken;
    }

    public ProductDAO getProduct() {
        return product;
    }

    public void setProduct(ProductDAO product) {
        this.product = product;
    }

    public int getQty_taken() {
        return qty_taken;
    }

    public void setQty_taken(int qty_taken) {
        this.qty_taken = qty_taken;
    }
}
