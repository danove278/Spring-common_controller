package com.curso.spring.sistema_facturacion.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    private String descripcion;

    private String observacion;
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @PrePersist
    private void prePersist(){
        this.createAt = new Date();
    }

    //    Relacion Bidireccional con Cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "facturas"})
    private Cliente cliente;

//    Relacion Unidireccional con ITEM Factura
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler"})
    private Set<ItemFactura> items = new HashSet<>();

    public void addItems(Set<ItemFactura> items) {
        this.items.addAll(items);
    }
    public void removeItems(Set<ItemFactura> items) {
        this.items.removeAll(items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factura factura = (Factura) o;

        return id.equals(factura.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Serial
    private static final long serialVersionUID = -3533138871385083850L;
}
