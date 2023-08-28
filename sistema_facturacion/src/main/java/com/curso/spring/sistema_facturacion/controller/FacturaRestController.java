package com.curso.spring.sistema_facturacion.controller;

import com.curso.spring.sistema_facturacion.entities.Factura;
import com.curso.spring.sistema_facturacion.service.IFacturaService;
import common_tools.common_controller_service.controller.EntityRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/factura")
public class FacturaRestController <E , I , S extends IFacturaService<E, I>>
        extends EntityRestController<E, I , S > {

    @Autowired
    private S service;
}
