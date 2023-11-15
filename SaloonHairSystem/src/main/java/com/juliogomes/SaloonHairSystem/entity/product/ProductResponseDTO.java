package com.juliogomes.SaloonHairSystem.entity.product;

public record ProductResponseDTO(String id, String name, Double price, Double salesPrice) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice(), product.getSalesPrice());
    }
}
