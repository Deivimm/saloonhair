package com.juliogomes.SaloonHairSystem.entity.venda;

import com.juliogomes.SaloonHairSystem.entity.Client.Client;
import com.juliogomes.SaloonHairSystem.entity.fornecedor.Fornecedor;
import com.juliogomes.SaloonHairSystem.entity.product.Product;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "vendas")
@Table(name = "vendas")
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_cpf")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor_cnpj")
    private Fornecedor fornecedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private double valor;



}