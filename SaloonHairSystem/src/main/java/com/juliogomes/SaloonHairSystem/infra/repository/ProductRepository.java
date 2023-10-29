package com.juliogomes.SaloonHairSystem.infra.repository;

import com.juliogomes.SaloonHairSystem.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
