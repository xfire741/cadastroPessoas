package com.eduardo.cadastropessoas.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.cadastropessoas.domain.exception.EntidadeNaoEncontradaException;
import com.eduardo.cadastropessoas.domain.model.Pessoa;
import com.eduardo.cadastropessoas.domain.repository.PessoaRepository;

@Service
public class PessoaCadastroService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa buscarOuFalhar(Long id) {
		return pessoaRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Pessoa com o id %d não encontrada", id)));
	}
	
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

}
