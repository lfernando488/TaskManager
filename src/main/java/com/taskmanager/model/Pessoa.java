package com.taskmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pessoa_id")
    private List<Tarefa> tarefas;

}
