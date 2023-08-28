package com.curso.spring.sistema_facturacion.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private Double precio;

    @Serial
    private static final long serialVersionUID = -4732741582374114477L;
}
