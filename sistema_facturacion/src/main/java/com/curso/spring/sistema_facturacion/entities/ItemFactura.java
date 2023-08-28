package com.curso.spring.sistema_facturacion.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "items_factura")
public class ItemFactura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer cantidad;


    //    Relacion con Producto
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "producto_id", nullable = false, foreignKey = @ForeignKey(name = "PRODUCTO_ID_FK"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Producto producto;



    public Double calcularImporte() {
        return this.producto.getPrecio() * this.cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemFactura that = (ItemFactura) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Serial
    private static final long serialVersionUID = 9033293517545379967L;
}
