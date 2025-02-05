package com.juliogomes.SaloonHairSystem.entity.Client;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;


@Entity(name = "client")
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, name = "cpf")
    private String cpf;
    private String name;
    private String secondName;
    private String endereco;
    private String cidade;
    private String uf;
    private String cep;
    private String  rg;
    private String dateNasc;
    private String fone;
    private String celular1;
    private String celular2;

    @Column(unique = true)
    private String email;

    public Client(ClientRequestDTO data){

        this.name = data.name();
        this.cpf = data.cpf();
        this.secondName = data.secondName();
        this.endereco = data.endereco();
        this.cidade = data.cidade();
        this.uf = data.uf();
        this.cep = data.cep();
        this.rg = data.rg();
        this.dateNasc = data.dateNasc();
        this.fone = data.fone();
        this.celular1 = data.celular1();
        this.celular2 = data.celular2();
        this.email = data.email();
    }

}
