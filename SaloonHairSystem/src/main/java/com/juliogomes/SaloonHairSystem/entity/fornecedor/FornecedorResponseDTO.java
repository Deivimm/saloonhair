package com.juliogomes.SaloonHairSystem.entity.fornecedor;

public record FornecedorResponseDTO(
        String cnpj,
        String razaoSocial,
        String nomeFantasia,
        String endereco,
        String cidade,
        String cep,
        String fone,
        String celular,
        String email) {
    public FornecedorResponseDTO(Fornecedor fornecedor){
        this(fornecedor.getCnpj(), fornecedor.getRazaoSocial(), fornecedor.getNomeFantasia(), fornecedor.getEndereco(), fornecedor.getCidade(),
                fornecedor.getCep(), fornecedor.getFone(), fornecedor.getCelular(), fornecedor.getEmail());
    }
}
