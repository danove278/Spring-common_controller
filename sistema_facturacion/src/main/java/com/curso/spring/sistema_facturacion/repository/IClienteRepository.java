package com.curso.spring.sistema_facturacion.repository;

import com.curso.spring.sistema_facturacion.entities.Cliente;
import common_tools.common_controller_service.repository.IEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository<E extends Cliente, I extends Integer> extends IEntityRepository<E, I> {
}
