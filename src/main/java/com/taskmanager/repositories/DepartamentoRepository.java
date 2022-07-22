package com.taskmanager.repositories;

import com.taskmanager.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento,Long> {
}
