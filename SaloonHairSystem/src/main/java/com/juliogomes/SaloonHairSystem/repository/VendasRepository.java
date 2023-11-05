package com.juliogomes.SaloonHairSystem.repository;

import com.juliogomes.SaloonHairSystem.entity.venda.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VendasRepository extends JpaRepository<Vendas, UUID> {
}
