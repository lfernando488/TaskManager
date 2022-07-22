package com.taskmanager.controllers;

import com.taskmanager.DTO.DepartamentoDTO;
import com.taskmanager.model.Departamento;
import com.taskmanager.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping(value = "/novo")
    public ResponseEntity cadastrarDepartamento(@RequestBody DepartamentoDTO departamentoDTO){
        Departamento novoDepto = departamentoDTO.DTOToModel();
        if(novoDepto != null) {
            departamentoService.adicionarDepartamento(novoDepto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }

    @GetMapping(value = "/todos")
    public ResponseEntity<List<Departamento>> listarDepartamentos(){
        List<Departamento> departamentos = departamentoService.listarDepartamentos();
        return ResponseEntity.ok(departamentos);
    }

}
