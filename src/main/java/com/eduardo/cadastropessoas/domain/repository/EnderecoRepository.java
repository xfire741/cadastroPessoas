package com.eduardo.cadastropessoas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eduardo.cadastropessoas.domain.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	@Query("from Endereco where pessoa.id = :id")
	List<Endereco> enderecosPorPessoa(@Param("id") Long id);
	
}
