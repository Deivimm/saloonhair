package com.juliogomes.SaloonHairSystem.entity.Client;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record ClientRequestDTO(
        @NotBlank
        String cpf,

        @NotNull
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
        
        String rg,

        @NotNull
        String dateNasc,

        String fone,

        @NotNull
        String celular1,


        String celular2,

        @NotNull
        String email
) {
}
