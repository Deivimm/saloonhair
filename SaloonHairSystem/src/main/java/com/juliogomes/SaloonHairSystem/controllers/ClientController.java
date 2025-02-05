package com.juliogomes.SaloonHairSystem.controllers;

import com.juliogomes.SaloonHairSystem.entity.Client.Client;
import com.juliogomes.SaloonHairSystem.entity.Client.ClientRequestDTO;
import com.juliogomes.SaloonHairSystem.entity.Client.ClientResponseDTO;
import com.juliogomes.SaloonHairSystem.entity.product.Product;
import com.juliogomes.SaloonHairSystem.entity.product.ProductResponseDTO;
import com.juliogomes.SaloonHairSystem.repository.ClientRepository;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    ClientRepository repository;

    @PostMapping
    public ResponseEntity postClient(@RequestBody @Valid ClientRequestDTO body){
        Client newClient = new Client(body);

        this.repository.save(newClient);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<?> getAllClient(){
        List<ClientResponseDTO> clientList = this.repository.findAll().stream().map(ClientResponseDTO::new).toList();

        return ResponseEntity.ok(clientList);
    }
    @GetMapping("/{id}")
    public ResponseEntity getClientById(@PathVariable String id){
        Optional<Client> client = this.repository.findById(id);

        if(client.isPresent()){
            ClientResponseDTO responseDTO = new ClientResponseDTO(client.get());
            return ResponseEntity.ok(responseDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable(value = "id") String id, @RequestBody @Valid ClientRequestDTO body){
        Optional<Client> optionalClient = this.repository.findById(id);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable String id) {
        try {
            Optional<Client> optionalClient = this.repository.findById(id);
            if (optionalClient.isPresent()) {
                this.repository.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
