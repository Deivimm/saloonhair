package com.juliogomes.SaloonHairSystem.entity.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientRequestDTO(
        @NotBlank
        String name,

        @NotNull
        String secondName,

        @NotNull
        String endereco,

        @NotNull
        String cidade,

        @NotNull
        String uf,

        @NotNull
        String cep,

        @NotNull
        Integer rg,

        @NotNull
        String dateNasc,

        @NotNull
        String fone,

        @NotNull
        String celular1,

        @NotNull
        String celular2,

        @NotNull
        String email
) {
}
