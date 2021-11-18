package org.shifted.service;

import org.shifted.entity.cart.CartContentDAO;
import org.shifted.entity.cart.CartDAO;
import org.shifted.entity.product.ProductDAO;
import org.shifted.repository.CartContentRepository;
import org.shifted.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartContentRepository cartContentRepository;

    @Autowired
    private CartRepository cartRepository;

    public CartDAO initCart(String user_id) {
        CartDAO cart = cartRepository.findByStatusAndUserId(user_id);
        if (cart != null) {
            return cart;
        } else {
            return createCart(user_id);
        }
    }

    public CartDAO createCart(String user_id) {
        CartDAO cartDAO = new CartDAO();
        cartDAO.setUser_id(user_id);
        return cartRepository.save(cartDAO);
    }

    public CartContentDAO fillCart(CartDAO cart, ProductDAO product, int qty) {

        CartContentDAO cartContentDAO = cartContentRepository.findByProductIdAndCartId(cart.getCart_id(), product.getProduct_id());

        if (cartContentDAO != null) {
            cartContentDAO.setProduct_incart_qty(qty);
            return cartContentRepository.save(cartContentDAO);
        } else {
            cartContentDAO = new CartContentDAO();
            cartContentDAO.setCart(cart);
            cartContentDAO.setProduct(product);
            cartContentDAO.setProduct_incart_qty(qty);
            return cartContentRepository.save(cartContentDAO);
        }
    }
}
