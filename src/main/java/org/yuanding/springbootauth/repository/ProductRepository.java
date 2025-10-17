package org.yuanding.springbootauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yuanding.springbootauth.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
