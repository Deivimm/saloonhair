package com.juliogomes.SaloonHairSystem.controllers;

import com.juliogomes.SaloonHairSystem.entity.product.Product;
import com.juliogomes.SaloonHairSystem.entity.product.ProductRequestDTO;
import com.juliogomes.SaloonHairSystem.entity.product.ProductResponseDTO;
import com.juliogomes.SaloonHairSystem.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @PostMapping
    public ResponseEntity postProduct(@RequestBody @Valid ProductRequestDTO body){
        Product newProduct = new Product(body);

        this.repository.save(newProduct);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity getAllProducts(){
        List<ProductResponseDTO> productList = this.repository.findAll().stream().map(ProductResponseDTO::new).toList();

        return ResponseEntity.ok(productList);

    }
    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable String id){
        Optional<Product> product = this.repository.findById(id);

        if(product.isPresent()){
            ProductResponseDTO responseDTO = new ProductResponseDTO(product.get());
            return ResponseEntity.ok(responseDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        Optional<Product> product = this.repository.findById(id);

        if(product.isPresent()){
            this.repository.delete(product.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
