package com.juliogomes.SaloonHairSystem.repository;

import com.juliogomes.SaloonHairSystem.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
