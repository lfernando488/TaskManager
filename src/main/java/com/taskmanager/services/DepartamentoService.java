package com.taskmanager.services;

import com.taskmanager.model.Departamento;
import com.taskmanager.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public void adicionarDepartamento(Departamento departamento){
        departamentoRepository.save(departamento);
    }

    public List<Departamento> listarDepartamentos (){
        return departamentoRepository.findAll();
    }

}
