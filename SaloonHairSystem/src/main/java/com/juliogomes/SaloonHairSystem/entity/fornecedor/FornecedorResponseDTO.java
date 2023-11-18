package com.juliogomes.SaloonHairSystem.entity.fornecedor;

public record FornecedorResponseDTO(
        String id,
        String cnpj,
        String razaoSocial,
        String nomeFantasia,
        String endereco,
        String cidade,
        String uf,
        String cep,
        String fone,
        String celular,
        String email) {

    public FornecedorResponseDTO(Fornecedor fornecedor){
            this(fornecedor.getId(), fornecedor.getCnpj(), fornecedor.getRazaoSocial(),
                    fornecedor.getNomeFantasia(), fornecedor.getEndereco(),
                    fornecedor.getCidade(), fornecedor.getUf(),
                    fornecedor.getCep(), fornecedor.getFone(), fornecedor.getCelular(),
                    fornecedor.getEmail());
        }
    }

