package com.eduardo.cadastropessoas.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.cadastropessoas.domain.exception.EntidadeNaoEncontradaException;
import com.eduardo.cadastropessoas.domain.model.Endereco;
import com.eduardo.cadastropessoas.domain.model.Pessoa;
import com.eduardo.cadastropessoas.domain.repository.EnderecoRepository;

@Service
public class EnderecoCadastroService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PessoaCadastroService pessoaCadastro;
	
	public Endereco salvar(Endereco endereco) {
		Long pessoaId = endereco.getPessoa().getId();
		
		Pessoa pessoa = pessoaCadastro.buscarOuFalhar(pessoaId);
		
		endereco.setPessoa(pessoa);
		
		return enderecoRepository.save(endereco);
	}
	
	public Endereco buscarOuFalhar(Long id) {
		return enderecoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Endereço com o id %d não encontrado", id)));
	}

}
