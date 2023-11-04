package com.juliogomes.SaloonHairSystem.entity.fornecedor;

public record FornecedorResponseDTO(
        Long cnpj,
        String razaoSocial,
        String endereco,
        String cidade,
        String cep,
        String fone,
        String celular,
        String email) {
    public FornecedorResponseDTO(Fornecedor fornecedor){
        this(fornecedor.getCnpj(), fornecedor.getRazaoSocial(), fornecedor.getEndereco(), fornecedor.getCidade(),
                fornecedor.getCep(), fornecedor.getFone(), fornecedor.getCelular(), fornecedor.getEmail());
    }
}
