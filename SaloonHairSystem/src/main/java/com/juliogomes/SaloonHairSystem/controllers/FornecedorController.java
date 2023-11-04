package com.juliogomes.SaloonHairSystem.controllers;

import com.juliogomes.SaloonHairSystem.entity.fornecedor.Fornecedor;
import com.juliogomes.SaloonHairSystem.entity.fornecedor.FornecedorRequestDTO;
import com.juliogomes.SaloonHairSystem.entity.fornecedor.FornecedorResponseDTO;
import com.juliogomes.SaloonHairSystem.repository.FornecedorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
   FornecedorRepository repository;

    @PostMapping
    public ResponseEntity<?> postFornecedor(@RequestBody @Valid FornecedorRequestDTO body){
        Fornecedor newFornecedor = new Fornecedor();
        newFornecedor.setRazaoSocial(body.razaoSocial());
        newFornecedor.setFone(body.fone());
        newFornecedor.setCelular(body.celular());
        newFornecedor.setEmail(body.email());

        this.repository.save(newFornecedor);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<?> getAllFornecedor(){
        List<FornecedorResponseDTO> fornecedorList =
                this.repository.findAll().stream().map(FornecedorResponseDTO::new).toList();

        return ResponseEntity.ok(fornecedorList);
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity<?> updateFornecedor(@PathVariable Long cnpj,@RequestBody @Valid FornecedorRequestDTO body){

        if (repository.existsById(cnpj)){

           Fornecedor fornecedor = repository.findById(cnpj).get();

            fornecedor.setRazaoSocial(body.razaoSocial());
            fornecedor.setFone(body.fone());
            fornecedor.setCelular(body.celular());
            fornecedor.setEmail(body.email());

            repository.save(fornecedor);
            return ResponseEntity.ok().build();
        } else {
                return ResponseEntity.notFound().build();
        }
    }
}
