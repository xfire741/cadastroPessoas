package com.eduardo.cadastropessoas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.cadastropessoas.domain.model.Endereco;
import com.eduardo.cadastropessoas.domain.repository.EnderecoRepository;
import com.eduardo.cadastropessoas.domain.service.EnderecoCadastroService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoCadastroService enderecoCadastro;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping("/{id}")
	public Endereco buscar(@PathVariable Long id) {
		return enderecoCadastro.buscarOuFalhar(id);
	}
	
	@GetMapping
	public List<Endereco> listar() {
		return enderecoRepository.findAll();
	}
	
}
