package com.taskmanager.services;

import com.taskmanager.DTO.TarefaAlocarDTO;
import com.taskmanager.model.Departamento;
import com.taskmanager.model.Pessoa;
import com.taskmanager.model.Tarefa;
import com.taskmanager.repositories.DepartamentoRepository;
import com.taskmanager.repositories.PessoaRepository;
import com.taskmanager.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Boolean adicionarTarefa(Tarefa tarefa){
        try {
            Long idDepto = tarefa.getDepartamento().getId();
            if(idDepto != null && idDepto > 0)
            {
                Optional<Departamento> depto = departamentoRepository.findById(idDepto);
                if(depto.isPresent())
                {
                    tarefaRepository.save(tarefa);
                    return true;
                }
                else
                {throw new Exception("O Departamento de ID: " +idDepto + " nao existe!");}
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Tarefa> listarTodas(){
        return tarefaRepository.findAll();
    }

    public List<Tarefa> tarefasPendentes(){
        return tarefaRepository.tarefasPendentes();
    }

    public void alocarPessoa(TarefaAlocarDTO tarefaAlocarDTO, Long id_pessoa) {
        try{
            Pessoa pessoa = pessoaRepository.findById(id_pessoa).orElse(null);
            Tarefa tarefa = tarefaRepository.findById(tarefaAlocarDTO.getId()).orElse(null);
            if(pessoa != null && tarefa != null){
                if(tarefaAlocarDTO.getDepartamento().getId() == pessoa.getDepartamento().getId()){
                    tarefa.setPessoa(pessoa);
                    tarefaRepository.save(tarefa);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Tarefa finalizar(Long id_tarefa) {
        Tarefa tarefa = tarefaRepository.findById(id_tarefa).orElse(null);
        if (tarefa != null) {
            tarefa.setFinalizada(true);
            return tarefaRepository.save(tarefa);
        }else{
            throw new RuntimeException("A Tarefa não existe no banco de dados");
        }
    }
}
