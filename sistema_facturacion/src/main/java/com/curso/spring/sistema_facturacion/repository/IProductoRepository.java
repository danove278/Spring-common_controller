package com.curso.spring.sistema_facturacion.repository;

import com.curso.spring.sistema_facturacion.entities.Producto;
import common_tools.common_controller_service.repository.IEntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository <E extends Producto, I extends Integer> extends IEntityRepository<E, I> {
}
