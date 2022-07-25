package com.taskmanager.DTO;

import com.taskmanager.model.Departamento;
import com.taskmanager.model.Pessoa;
import com.taskmanager.model.Tarefa;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private Long id;
    private String nome;
    private Departamento departamento;

    private List<Tarefa> tarefas;

    public Pessoa novaPessoa(){
        return new Pessoa(null, this.nome, this.departamento, null);
    }

    public Pessoa alterarPessoa(){
        return new Pessoa(this.nome, this.departamento);
    }

}
