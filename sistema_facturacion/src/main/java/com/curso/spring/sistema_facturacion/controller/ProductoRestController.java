package com.curso.spring.sistema_facturacion.controller;

import com.curso.spring.sistema_facturacion.service.IClienteService;
import com.curso.spring.sistema_facturacion.service.IProductoService;
import common_tools.common_controller_service.controller.EntityRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producto")
public class ProductoRestController <E, I, S extends IProductoService<E, I>>
        extends EntityRestController<E, I , S > {
    @Autowired
    private S service;
}
