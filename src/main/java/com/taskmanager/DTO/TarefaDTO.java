package com.taskmanager.DTO;


import com.taskmanager.model.Departamento;
import com.taskmanager.model.Pessoa;
import com.taskmanager.model.Tarefa;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private Integer duracao;
    private boolean finalizada;
    private Pessoa pessoa;
    private Departamento departamento;

    public Tarefa DTOtoModel(){
        return new Tarefa(this.id, this.titulo, this.descricao, this.prazo, this.duracao, this.finalizada, this.pessoa, this.departamento);
    }
}
