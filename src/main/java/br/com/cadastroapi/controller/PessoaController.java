package br.com.cadastroapi.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastroapi.controller.form.PessoaForm;
import br.com.cadastroapi.modelo.Pessoa;
import br.com.cadastroapi.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
		
	@GetMapping
	public List<Pessoa> listar() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Pessoa buscarPorId(@PathVariable Long id) {
		Optional<Pessoa> pessoa = repository.findById(id);
		if (pessoa.isPresent()) {
			return pessoa.get();
		}
		return null;
	}
	
	@PostMapping
	public void criar(@RequestBody @Valid PessoaForm form) {
		repository.save(form.converter());
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody PessoaForm form) {
		Optional<Pessoa> pessoa = repository.findById(id);
		form.atualizar(pessoa.get());
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
