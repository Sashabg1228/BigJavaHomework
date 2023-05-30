package com.example.bigjavahomework.entityes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customers {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition = "INTEGER")
    private Integer id;

    @Column(name = "username", nullable = false, columnDefinition = "VARCHAR(25)")
    private String username;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(25)")
    private String password;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(25)")
    private String name;

    @ManyToOne
    @JoinColumn(name = "addressID", nullable = false, referencedColumnName = "id")
    private Addresses address;
}
