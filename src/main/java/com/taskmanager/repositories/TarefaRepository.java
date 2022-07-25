package com.taskmanager.repositories;

import com.taskmanager.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query(value="SELECT * FROM tb_Tarefa WHERE pessoa_id IS NULL ORDER BY prazo ASC LIMIT 3", nativeQuery = true)
    List<Tarefa> tarefasPendentes();

}
