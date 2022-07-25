package com.taskmanager.model;

import com.taskmanager.DTO.TarefaDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_Tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private Integer duracao;
    private boolean finalizada;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    public TarefaDTO modelToDTO(){
        return new TarefaDTO(this.id, this.titulo, this.descricao, this.prazo, this.duracao, this.finalizada, this.pessoa, this.departamento);
    }

}
