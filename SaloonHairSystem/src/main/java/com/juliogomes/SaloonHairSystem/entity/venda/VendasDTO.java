package com.juliogomes.SaloonHairSystem.entity.venda;

import lombok.Data;

import java.util.UUID;

@Data
public class VendasDTO {
    private UUID id;
    private Long clientCpf;
    private Long fornecedorCnpj;
    private Long productId;
    private Double value;

}