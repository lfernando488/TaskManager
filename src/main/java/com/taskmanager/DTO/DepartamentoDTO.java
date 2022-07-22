package com.taskmanager.DTO;

import com.taskmanager.model.Departamento;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartamentoDTO {

    private Long id;
    private String nome;


    public Departamento DTOToModel(){
        return new Departamento(this.nome);
    }

}
