package com.juliogomes.SaloonHairSystem.repository;

import com.juliogomes.SaloonHairSystem.entity.fornecedor.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
