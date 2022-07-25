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
        try{ pessoaRepository.save(pessoa);}
        catch (Exception e){e.printStackTrace();}
    }

    public Pessoa alterarPessoa(Pessoa pessoa, Long id){
        //Validar
        Optional<Pessoa> p = pessoaRepository.findById(id);
        if(p.isPresent()){
            pessoa.setId(id);
            return pessoaRepository.save(pessoa);
        }
        //Tratar melhor
        return null;
    }

    public void adicionarDepartamento(Pessoa pessoaDepto) {
        pessoaRepository.save(pessoaDepto);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPessoas(Long id) {
        return pessoaRepository.findById(id);
    }

    public void excluirPessoa(Long id){
        pessoaRepository.deleteById(id);
    }

}
