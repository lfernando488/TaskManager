package com.taskmanager.DTO;

import com.taskmanager.model.Departamento;
import com.taskmanager.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaAlocarDTO {

    private Long id;
    private boolean finalizada;
    private Departamento departamento;
}
