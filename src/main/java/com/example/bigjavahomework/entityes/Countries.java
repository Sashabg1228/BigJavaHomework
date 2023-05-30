package com.example.bigjavahomework.entityes;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "countries")
@Data
public class Countries {
    @Id
    @Column(name = "code", nullable = false, columnDefinition = "VARCHAR(2)")
    private String code;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(56)")
    private String name;
    @Column(name = "location", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean location;
    @Column(name = "allowed", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean allowed;
}
