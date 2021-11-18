package org.shifted.entity.product;

public class ProductInCartDTO {

    private long product_id;

    private String product_name;

    private int product_price;

    private String product_desc;

    private String product_image;

    private int product_incart_qty;

    public ProductInCartDTO(long product_id, String product_name, int product_price, String product_desc, String product_image, int product_incart_qty) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_desc = product_desc;
        this.product_image = product_image;
        this.product_incart_qty = product_incart_qty;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public int getProduct_incart_qty() {
        return product_incart_qty;
    }

    public void setProduct_incart_qty(int product_incart_qty) {
        this.product_incart_qty = product_incart_qty;
    }
}
