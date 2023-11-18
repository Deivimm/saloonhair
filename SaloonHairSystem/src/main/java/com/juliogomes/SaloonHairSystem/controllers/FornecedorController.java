package com.juliogomes.SaloonHairSystem.controllers;

import com.juliogomes.SaloonHairSystem.entity.fornecedor.Fornecedor;
import com.juliogomes.SaloonHairSystem.entity.fornecedor.FornecedorRequestDTO;
import com.juliogomes.SaloonHairSystem.entity.fornecedor.FornecedorResponseDTO;
import com.juliogomes.SaloonHairSystem.entity.product.Product;
import com.juliogomes.SaloonHairSystem.entity.product.ProductResponseDTO;
import com.juliogomes.SaloonHairSystem.repository.FornecedorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {

    @Autowired
   FornecedorRepository repository;

    @PostMapping
    public ResponseEntity postFornecedor(@RequestBody @Valid FornecedorRequestDTO body){
        Fornecedor newFornecedor = new Fornecedor(body);

        this.repository.save(newFornecedor);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<?> getAllFornecedor(){
        List<FornecedorResponseDTO> fornecedorList =
                this.repository.findAll().stream().map(FornecedorResponseDTO::new).toList();

        return ResponseEntity.ok(fornecedorList);
    }
    @GetMapping("/{id}")
    public ResponseEntity getFornecedorById(@PathVariable String id){
        Optional<Fornecedor> fornecedor = this.repository.findById(id);

        if(fornecedor.isPresent()){
           FornecedorResponseDTO responseDTO = new FornecedorResponseDTO(fornecedor.get());
            return ResponseEntity.ok(responseDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFornecedor(@PathVariable(value = "id") String id, @RequestBody @Valid FornecedorRequestDTO body){
            Optional<Fornecedor>OptionalFornecedor = this.repository.findById(id);
            if (OptionalFornecedor.isPresent()){
                Fornecedor fornecedor = OptionalFornecedor.get();

                fornecedor.setCnpj(body.cnpj());
                fornecedor.setRazaoSocial(body.razaoSocial());
                fornecedor.setNomeFantasia(body.nomeFantasia());
                fornecedor.setEndereco(body.endereco());
                fornecedor.setCidade(body.cidade());
                fornecedor.setUf(body.uf());
                fornecedor.setCep(body.cep());
                fornecedor.setFone(body.fone());
                fornecedor.setCelular(body.celular());
                fornecedor.setEmail(body.email());


            this.repository.save(fornecedor);
            return ResponseEntity.ok().build();
        } else {
                return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteFornecedor(@PathVariable String id){
        Optional<Fornecedor> fornecedor = this.repository.findById(id);

        if(fornecedor.isPresent()){
            this.repository.delete(fornecedor.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
