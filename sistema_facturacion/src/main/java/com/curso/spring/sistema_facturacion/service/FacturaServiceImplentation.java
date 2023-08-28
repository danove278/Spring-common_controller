package com.curso.spring.sistema_facturacion.service;

import com.curso.spring.sistema_facturacion.entities.Factura;
import com.curso.spring.sistema_facturacion.repository.IFacturaRepository;
import common_tools.common_controller_service.service.EntityServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacturaServiceImplentation <E extends Factura, I extends Integer, R extends IFacturaRepository<E, I>>
        extends EntityServiceImplementation<E, I, R>
        implements IFacturaService<E, I>{

}
