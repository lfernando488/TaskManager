package com.taskmanager.model;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_Tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String título;
    private String descricao;
    private LocalDate prazo;
    private Duration duracao;
    private boolean finalizada;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

}
