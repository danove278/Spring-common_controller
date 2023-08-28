package com.curso.spring.sistema_facturacion.service;

import com.curso.spring.sistema_facturacion.entities.Producto;
import com.curso.spring.sistema_facturacion.repository.IProductoRepository;
import common_tools.common_controller_service.service.EntityServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImplentation<E extends Producto, I extends Integer, R extends IProductoRepository<E, I>>
        extends EntityServiceImplementation<E, I, R>
implements IProductoService<E, I>{
}
