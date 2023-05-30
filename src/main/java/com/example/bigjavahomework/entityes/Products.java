package com.example.bigjavahomework.entityes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Products {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition = "INTEGER")
    private Integer id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(name = "price", nullable = false, columnDefinition = "NUMERIC(6,2)")
    private Double price;

    @Column(name = "quantity", nullable = false, columnDefinition = "INTEGER")
    private Integer quantity;

    @Column(name = "weight", nullable = false, columnDefinition = "NUMERIC(6,3)")
    private Double weight;

    @Column(name = "info", nullable = false, columnDefinition = "VARCHAR(200)")
    private String info;

}
