package com.juliogomes.SaloonHairSystem.entity.product;

import com.juliogomes.SaloonHairSystem.entity.fornecedor.Fornecedor;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "product")
@Entity(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    private Double price;

    private Double salesPrice;

    public Product(ProductRequestDTO data){
        this.name = data.name();
        this.price = data.price();
        this.salesPrice = data.salesPrice();

    }
}
