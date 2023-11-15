package com.juliogomes.SaloonHairSystem.entity.fornecedor;
import jakarta.validation.constraints.NotNull;


public record FornecedorRequestDTO(
            @NotNull
            String cnpj,
            @NotNull
            String razaoSocial,
            @NotNull
            String nomeFantasia,
            @NotNull
            String endereco,
            @NotNull
            String cidade,
            @NotNull
            String uf,
            @NotNull
            String cep,
            @NotNull
            String fone,
            @NotNull
            String celular,
            @NotNull
            String email

    ) {

    }

