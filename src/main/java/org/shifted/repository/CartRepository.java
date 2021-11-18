package org.shifted.repository;

import org.shifted.entity.cart.CartDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<CartDAO, Integer> {

    @Query("SELECT c FROM CartDAO c WHERE c.cart_status = Active AND user_id = ?1")
    CartDAO findByStatusAndUserId(String user_id);

    @Query("SELECT c FROM CartDAO c WHERE c.cart_id = ?1")
    CartDAO findByCartId(long cartId);
}
