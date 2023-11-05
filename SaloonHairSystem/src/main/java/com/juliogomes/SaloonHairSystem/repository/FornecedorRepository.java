package com.juliogomes.SaloonHairSystem.repository;

import com.juliogomes.SaloonHairSystem.entity.fornecedor.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {
}
