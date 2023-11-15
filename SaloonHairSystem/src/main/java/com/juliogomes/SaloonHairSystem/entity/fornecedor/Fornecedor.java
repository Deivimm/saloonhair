package com.juliogomes.SaloonHairSystem.entity.fornecedor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true)
    private String cnpj;

    private String razaoSocial;
    private String nomeFantasia;
    private String endereco;
    private String cidade;
    private String uf;
    private String cep;
    private String fone;
    private String celular;
    @Column(unique = true)
    private String email;

    public Fornecedor(FornecedorRequestDTO data){
        this.cnpj = data.cnpj();
        this.razaoSocial = data.razaoSocial();
        this.nomeFantasia = data.nomeFantasia();
        this.endereco = data.endereco();
        this.cidade = data.cidade();
        this.uf = data.uf();
        this.cep =data.cep();
        this.fone = data.fone();
        this.celular = data.celular();
        this.email = data.email();
    }

}
