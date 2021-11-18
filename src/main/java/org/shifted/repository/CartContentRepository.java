package org.shifted.repository;

import org.shifted.entity.cart.CartContentDAO;
import org.shifted.entity.product.ProductInCartDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartContentRepository extends CrudRepository<CartContentDAO, Integer> {

    @Query("SELECT new org.shifted.entity.product.ProductInCartDTO(p.product_id, p.product_name, p.product_price, p.product_desc, p.product_image, c.product_incart_qty)"
            + " FROM CartContentDAO c INNER JOIN c.cart a INNER JOIN c.product p WHERE a.cart_id = ?1")
    List<ProductInCartDTO> findProductInCartByCartId(long cart_id);

    @Query("SELECT c FROM CartContentDAO c INNER JOIN c.product p INNER JOIN c.cart a WHERE a.cart_id = ?1 AND p.product_id = ?2")
    CartContentDAO findByProductIdAndCartId(long cart_id, long product_id);
}
