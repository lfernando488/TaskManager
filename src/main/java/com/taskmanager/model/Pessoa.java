package com.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taskmanager.DTO.PessoaDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nome;

    @OneToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="pessoa_id")
    private List<Tarefa> tarefas;

    public PessoaDTO modetlToDTO(){
        return new PessoaDTO(this.id, this.nome, this.departamento, this.tarefas);
    }

    public Pessoa (String nome, Departamento departamento){
        this.nome = nome;
        this.departamento = departamento;
    }


}
