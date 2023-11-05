package com.juliogomes.SaloonHairSystem.entity.fornecedor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String endereco;
    private String cidade;
    private String uf;
    private String cep;
    private String fone;
    private String celular;
    private String email;


}
