package com.example.bigjavahomework.entityes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "addresses")
@Data
public class Addresses{
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition = "INTEGER")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "countryCode", nullable = false, referencedColumnName = "code")
    private Countries country;

    @Column(name = "city", nullable = false, columnDefinition = "VARCHAR(25)")
    private String city;
    @Column(name = "street", nullable = false, columnDefinition = "VARCHAR(50)")
    private String street;
}
