package com.juliogomes.SaloonHairSystem.entity.Client;


public record ClientResponseDTO(
        String id,
        String cpf,
        String name,
        String secondName,
        String endereco,
        String cidade,
        String cep,
        String rg,
        String dateNasc,
        String fone,
        String celular1,
        String celular2,
        String email
) {
    public ClientResponseDTO(Client client){
        this(client.getId(), client.getCpf(),client.getName(), client.getSecondName(), client.getEndereco(), client.getCidade(),
                client.getCep(), client.getRg(), client.getDateNasc(), client.getFone(),
                client.getCelular1(), client.getCelular2(), client.getEmail());
    }
}
