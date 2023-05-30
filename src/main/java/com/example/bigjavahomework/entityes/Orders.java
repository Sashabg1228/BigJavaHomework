package com.example.bigjavahomework.entityes;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "orders")
@Data
public class Orders {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition = "INTEGER")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customerID", nullable = false, referencedColumnName = "id")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "addressID", nullable = false, referencedColumnName = "id")
    private Addresses address;

    @Column(name = "phone", nullable = false, columnDefinition = "VARCHAR(10)")
    private String phone;

    @Column(name = "creationDate", nullable = false, columnDefinition = "DATE")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "statusCode", nullable = false, referencedColumnName = "code")
    private Statuses status;
}
