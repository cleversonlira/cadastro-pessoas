package br.com.cadastroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastroapi.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
