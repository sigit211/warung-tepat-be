package org.shifted.entity.request;

import org.shifted.entity.cart.CartDAO;
import org.shifted.entity.product.ProductDAO;

public class FillCartRequest {

    private CartDAO cart;
    private ProductDAO product;
    private int product_qty;

    public FillCartRequest(CartDAO cart, ProductDAO product, int product_qty) {
        this.cart = cart;
        this.product = product;
        this.product_qty = product_qty;
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

    public int getProduct_qty() {
        return product_qty;
    }

    public void setProduct_qty(int product_qty) {
        this.product_qty = product_qty;
    }
}
