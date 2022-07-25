package com.taskmanager.controllers;

import com.taskmanager.DTO.PessoaDTO;
import com.taskmanager.DTO.TarefaAlocarDTO;
import com.taskmanager.DTO.TarefaDTO;
import com.taskmanager.model.Pessoa;
import com.taskmanager.model.Tarefa;
import com.taskmanager.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping(value = "/nova")
    public ResponseEntity cadastrarTarefa(@RequestBody TarefaDTO tarefaDTO){
        Tarefa novaTarefa = tarefaDTO.DTOtoModel();
        try{
            tarefaService.adicionarTarefa(novaTarefa);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/alocar/{id_pessoa}")
    public ResponseEntity alocarPessoa(@RequestBody TarefaAlocarDTO tarefaAlocarDTO, @PathVariable Long id_pessoa){
        try {
            tarefaService.alocarPessoa(tarefaAlocarDTO, id_pessoa);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value ="/todas")
    public ResponseEntity<List<Tarefa>> listarTarefas(){
        List<Tarefa> tarefas = tarefaService.listarTodas();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping(value ="/pendentes")
    public ResponseEntity<List<Tarefa>> tarefasPendentes(){
        List<Tarefa> tarefas = tarefaService.tarefasPendentes();
        return ResponseEntity.ok(tarefas);
    }

    @PutMapping(value = "/finalizar/{id_tarefa}")
    public ResponseEntity<Tarefa> finalizarTarefa(@PathVariable Long id_tarefa){
        try {
              Tarefa tarefa = tarefaService.finalizar(id_tarefa);
              return ResponseEntity.ok(tarefa);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
