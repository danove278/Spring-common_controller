package com.curso.spring.sistema_facturacion.controller;

import com.curso.spring.sistema_facturacion.entities.Cliente;
import com.curso.spring.sistema_facturacion.service.IClienteService;
import common_tools.common_controller_service.controller.EntityRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/cliente")
public class ClienteRestController<E extends Cliente, I extends Integer, S extends IClienteService<E, I>>
        extends EntityRestController<E, I, S> {
    @Autowired
    private S service;



}
