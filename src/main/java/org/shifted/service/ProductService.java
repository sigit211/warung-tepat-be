package org.shifted.service;

import org.shifted.entity.product.ProductDAO;
import org.shifted.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void updateStock(ProductDAO product, int qty_taken) {
        System.err.println(product.getProduct_name() + " " + qty_taken);
        product.setProduct_qty(product.getProduct_qty() - qty_taken);
        productRepository.save(product);
    }

}
