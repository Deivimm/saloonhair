package com.juliogomes.SaloonHairSystem.entity.fornecedor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;


    public record FornecedorRequestDTO(
            @NotBlank
            String razaoSocial,

            @NotNull
            String fone,

            @NotNull
            String celular,

            @NotNull
            String email

    ) {

    }

