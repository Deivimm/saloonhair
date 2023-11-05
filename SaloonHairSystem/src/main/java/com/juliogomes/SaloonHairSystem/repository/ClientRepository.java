package com.juliogomes.SaloonHairSystem.repository;

import com.juliogomes.SaloonHairSystem.entity.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
