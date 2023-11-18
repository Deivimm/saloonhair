package com.juliogomes.SaloonHairSystem.entity.venda;

import com.juliogomes.SaloonHairSystem.entity.Client.Client;
import com.juliogomes.SaloonHairSystem.entity.fornecedor.Fornecedor;
import com.juliogomes.SaloonHairSystem.entity.product.Product;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class VendasDTO {
    private Long id;
    private List<Client> client;
    private List<Fornecedor> fornecedor;
    private List<Product> products;
    private double value;

}