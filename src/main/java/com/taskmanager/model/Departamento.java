package com.taskmanager.model;

import com.taskmanager.DTO.DepartamentoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_Departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    public Departamento(String nome){
        this.nome = nome;
    }

    public DepartamentoDTO modelToDTO(Departamento departamento){
        return new DepartamentoDTO(departamento.getId(), departamento.getNome());
    }

}
