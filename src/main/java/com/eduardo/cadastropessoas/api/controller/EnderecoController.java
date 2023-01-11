package com.eduardo.cadastropessoas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.cadastropessoas.domain.model.Endereco;
import com.eduardo.cadastropessoas.domain.repository.EnderecoRepository;
import com.eduardo.cadastropessoas.domain.service.EnderecoCadastroService;
import com.eduardo.cadastropessoas.domain.service.PessoaCadastroService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private PessoaCadastroService pessoaCadastro;
	
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
	
	@PostMapping
	public Endereco adicionar(@RequestBody Endereco endereco) {
		return enderecoCadastro.salvar(endereco);
	}
	
	@GetMapping("/porPessoa/{id}")
	public List<Endereco> buscarEnderecosPorPessoa(@PathVariable Long id) {
		pessoaCadastro.buscarOuFalhar(id);
		return enderecoRepository.enderecosPorPessoa(id);		
	}
	
	@GetMapping("/definirPrincipal/{id}")
	public Endereco definirPrincipalByIdPessoa(@PathVariable Long id) {
		
		List<Endereco> enderecos = enderecoRepository.findAll();
		
		for (Endereco endereco : enderecos) {
			endereco.setPrincipal(false);
		}
		
		Endereco enderecoPrincipal = enderecoCadastro.buscarOuFalhar(id);
		enderecoPrincipal.setPrincipal(true);
		
		return enderecoCadastro.salvar(enderecoPrincipal);
		
	}
	
}
