package com.taskmanager.controllers;

import com.taskmanager.DTO.DepartamentoDTO;
import com.taskmanager.DTO.PessoaDTO;
import com.taskmanager.model.Departamento;
import com.taskmanager.model.Pessoa;
import com.taskmanager.services.DepartamentoService;
import com.taskmanager.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping(value = "/nova")
    public ResponseEntity cadastrarDepartamento(@RequestBody PessoaDTO pessoaDTO){
        Pessoa novaPessoa = pessoaDTO.DTOtoModel();
        if(novaPessoa != null) {
            pessoaService.adicionarDepartamento(novaPessoa);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }

    @GetMapping(value = "/todas")
    public ResponseEntity<List<Pessoa>> listarDepartamentos(){
        List<Pessoa> pessoas = pessoaService.listarPessoas();
        return ResponseEntity.ok(pessoas);
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<Pessoa> alterarPessoa(@RequestBody PessoaDTO pessoaDTO){
        return null;
    }

    @DeleteMapping(value = "/excluir/{id}")
    public ResponseEntity excluirPessoa(@PathVariable Long id){
        pessoaService.excluirPessoa(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
