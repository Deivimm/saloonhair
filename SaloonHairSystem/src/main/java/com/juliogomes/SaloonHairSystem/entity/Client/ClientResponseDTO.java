package com.juliogomes.SaloonHairSystem.entity.Client;

import java.util.UUID;

public record ClientResponseDTO(
        UUID cpf,
        String name,
        String secondName,
        String endereco,
        String cidade,
        String cep,
        Integer rg,
        String dateNasc,
        String fone,
        String celular1,
        String celular2,
        String email
) {
    public ClientResponseDTO(Client client){
        this(client.getCpf(),client.getName(), client.getSecondName(), client.getEndereco(), client.getCidade(),
                client.getCep(), client.getRg(), client.getDateNasc(), client.getFone(),
                client.getCelular1(), client.getCelular2(), client.getEmail());
    }
}
