package com.curso.spring.sistema_facturacion.service;

import com.curso.spring.sistema_facturacion.entities.Cliente;
import com.curso.spring.sistema_facturacion.repository.IClienteRepository;
import common_tools.common_controller_service.repository.IEntityRepository;
import common_tools.common_controller_service.service.EntityServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//public class ClienteServiceImplentation<E extends Cliente, I extends Integer, R extends IClienteRepository<E, I>>
//        extends EntityServiceImplementation<E, I, R > {
//
//}
public class ClienteServiceImplentation<E extends Cliente, I extends Integer, R extends IClienteRepository<E, I>>
        extends EntityServiceImplementation<E, I, R >
        implements IClienteService<E, I> {

}