package common_tools.common_controller_service.controller;

import common_tools.common_controller_service.service.IEntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityRestController<E, I, S extends IEntityService<E, I>> {
@Autowired
    protected S service;

    @Value("${entities.por.paginas}")
    private String entitiesPorPaginas;

    @GetMapping
    public List<E> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/page/{page}")
    public Page<E> index(@PathVariable Integer page){
        System.out.println(entitiesPorPaginas);
        return this.service.findAll(PageRequest.of(page, Integer.parseInt(entitiesPorPaginas) ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable I id) {
        Optional<E> entityOpt = this.service.findByID(id);
        if (entityOpt.isPresent())
            return ResponseEntity.ok(entityOpt.get());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("No existe el id: %d.", id));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody E entity, BindingResult result) {
//		El RequestBody se necesita porque recibimos los datos en formato JSON y esta anotacion se encarga
//		de transformarla en un objeto cliente.

//		El BindingResult es el objeto que contiene todos los mensajes de error.

        if (result.hasErrors()) {
            return this.validar(result);
        }
        try {
            this.service.create(entity);
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    String.format(String.format("%s: %s.", e.getMessage(), e.getMostSpecificCause().getMessage())));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable I id) {
        this.service.removeById(id);
    }

    private ResponseEntity<?> validar(BindingResult result) {

        List<String> errores = result.getFieldErrors().stream()
                .map(error -> String.format("El campo %s: %s.", error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        // -> solo si tenemos errores globales
        if (result.hasGlobalErrors()) {
            errores.add(result.getGlobalError().getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errores);
    }
}
