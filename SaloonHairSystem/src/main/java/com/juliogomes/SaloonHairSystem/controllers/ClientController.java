package com.juliogomes.SaloonHairSystem.controllers;

import com.juliogomes.SaloonHairSystem.entity.Client.Client;
import com.juliogomes.SaloonHairSystem.entity.Client.ClientRequestDTO;
import com.juliogomes.SaloonHairSystem.entity.Client.ClientResponseDTO;
import com.juliogomes.SaloonHairSystem.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepository repository;

    @PostMapping("/auth/client")
    public ResponseEntity<?> postClient(@RequestBody @Valid ClientRequestDTO body){
        Client newClient = new Client();

        this.repository.save(newClient);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{cpf}")
    public ResponseEntity<?> getAllClient(){
        List<ClientResponseDTO> clientList = this.repository.findAll().stream().map(ClientResponseDTO::new).toList();

        return ResponseEntity.ok(clientList);
    }
    @PutMapping("/{cpf}")
    public ResponseEntity<?> updateClient(@PathVariable UUID cpf, @RequestBody @Valid ClientRequestDTO body){
        Optional<Client> optionalClient = this.repository.findById(cpf);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();

            client.setName(body.name());
            client.setSecondName(body.secondName());
            client.setEndereco(body.endereco());
            client.setCidade(body.cidade());
            client.setCep(body.cep());
            client.setFone(body.fone());
            client.setCelular1(body.celular1());
            client.setCelular2(body.celular2());
            client.setEmail(body.email());

            this.repository.save(client);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> deleteClient(@PathVariable UUID cpf) {
        try {
            Optional<Client> optionalClient = this.repository.findById(cpf);
            if (optionalClient.isPresent()) {
                this.repository.deleteById(cpf);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
