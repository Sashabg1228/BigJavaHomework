package com.example.bigjavahomework.entityes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "statuses")
@Data
public class Statuses {
    @Id
    @Column(name = "code", nullable = false, columnDefinition = "VARCHAR(1)")
    private String code;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(9)")
    private String name;

}
