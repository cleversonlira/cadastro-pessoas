package br.com.cadastroapi.controller.dto;

import java.time.format.DateTimeFormatter;

import org.springframework.data.domain.Page;

import br.com.cadastroapi.modelo.Pessoa;

public class PessoaDTO {

	private Long id;
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String sexo;

	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		this.dataNascimento = pessoa.getDataNascimento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		this.sexo = pessoa.getSexo().toString().replaceAll("_", " ").toLowerCase();
	}

	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}
	
	public static Page<PessoaDTO> converterLista(Page<Pessoa> pessoas) {		
		return pessoas.map(PessoaDTO::new);
	}

}