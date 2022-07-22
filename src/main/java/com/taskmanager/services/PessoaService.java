package com.taskmanager.services;

import com.taskmanager.model.Pessoa;
import com.taskmanager.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    //- Adicionar um pessoa (post/pessoas)
    public void adicionarPessoa(Pessoa pessoa){
        Pessoa result = pessoaRepository.save(pessoa);
    }

    //- Alterar um pessoa (put/pessoas/{id})
    public Pessoa alterarPessoa(Pessoa pessoa, Long id){
        return null;
    }

    public void adicionarDepartamento(Pessoa novaPessoa) {
        pessoaRepository.save(novaPessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa alterarPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public void excluirPessoa(Long id){
        pessoaRepository.deleteById(id);
    }
}
