package com.curso.spring.sistema_facturacion.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(name = "nombres", nullable = false)
    private String nombre;

    private String apellido;

    private String email;
    @Temporal(TemporalType.DATE) //Indica como vamos a guardar la fecha
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = true)
    private Date createAt;

    @PrePersist
    private void prePersist(){ this.createAt = new Date(); }

    //    Relacion
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "curso"}, allowSetters = true)
    private Set<Factura> facturas = new HashSet<>();

    public void addFactura(Factura factura) {
        this.facturas.add(factura);
        factura.setCliente(this);
    }

    public void addFacturas(Set<Factura> alumnos) {
        alumnos.forEach(this::addFactura);
    }

    public void removeFactura(Factura factura) {
        this.facturas.remove(factura);
        factura.setCliente(null);
    }

    @Serial
    private static final long serialVersionUID = 4628682216969144834L;
}
