package br.com.cadastroapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cadastroapi.controller.dto.PessoaDTO;
import br.com.cadastroapi.controller.form.PessoaForm;
import br.com.cadastroapi.modelo.Pessoa;
import br.com.cadastroapi.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
		
	@GetMapping
	public List<PessoaDTO> listar() {
		return PessoaDTO.converterLista(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTO> buscarPorId(@PathVariable Long id) {
		Optional<Pessoa> pessoa = repository.findById(id);
		if (pessoa.isPresent()) {
			return ResponseEntity.ok(new PessoaDTO(pessoa.get()));			
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<PessoaDTO> criar(@RequestBody @Valid PessoaForm form, UriComponentsBuilder uriBuilder) {
		Pessoa pessoa = form.converter();
		repository.save(pessoa);
		URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).body(new PessoaDTO(pessoa));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PessoaDTO> atualizar(@PathVariable Long id, @RequestBody PessoaForm form) {
		Optional<Pessoa> pessoa = repository.findById(id);
		if (pessoa.isPresent()) {
			form.atualizar(pessoa.get());
			return ResponseEntity.ok(new PessoaDTO(pessoa.get()));			
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PessoaDTO> deletar(@PathVariable Long id) {		
		Optional<Pessoa> pessoa = repository.findById(id);
		if (pessoa.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();			
		}
		return ResponseEntity.notFound().build();
	}

}
