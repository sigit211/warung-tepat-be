package org.shifted.helper;

import org.shifted.entity.product.ProductStockUpdate;
import org.shifted.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductStockUpdater {

    @Autowired
    ProductService productService;

    public void stockUpdater(List<ProductStockUpdate> products) {
        for (ProductStockUpdate product : products) {
            try {
                productService.updateStock(product.getProduct(), product.getQty_taken());
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

}
