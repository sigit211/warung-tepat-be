package org.shifted.repository;

import org.shifted.entity.product.ProductDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductDAO, Integer> {
    List<ProductDAO> findAll();
}
