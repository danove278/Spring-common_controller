package com.curso.spring.sistema_facturacion.repository;

import com.curso.spring.sistema_facturacion.entities.Factura;
import common_tools.common_controller_service.repository.IEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturaRepository<E extends Factura, I extends Integer> extends IEntityRepository<E, I> {
}
