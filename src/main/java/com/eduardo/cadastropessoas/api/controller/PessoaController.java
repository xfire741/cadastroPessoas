package com.eduardo.cadastropessoas.api.controller;



import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.cadastropessoas.domain.model.Pessoa;
import com.eduardo.cadastropessoas.domain.repository.PessoaRepository;
import com.eduardo.cadastropessoas.domain.service.PessoaCadastroService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaCadastroService pessoaCadastro;
	
	
	@GetMapping("/{id}")
	public Pessoa buscar(@PathVariable Long id) {
		return pessoaCadastro.buscarOuFalhar(id);
	}
	
	@GetMapping
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}
	
	@PostMapping
	public Pessoa salvar(@RequestBody Pessoa pessoa) {
		return pessoaCadastro.salvar(pessoa);
	}
	
	@PutMapping("/{id}")
	public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		
		Pessoa pessoaAtual = pessoaCadastro.buscarOuFalhar(id);
		
		BeanUtils.copyProperties(pessoa, pessoaAtual, "id");
		
		return pessoaCadastro.salvar(pessoaAtual);
		
	}
	
}
