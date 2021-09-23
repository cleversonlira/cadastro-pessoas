package br.com.cadastroapi.controller.dto;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public static List<PessoaDTO> converterLista(List<Pessoa> pessoas) {		
		return pessoas.stream().map(pessoa -> new PessoaDTO(pessoa)).collect(Collectors.toList());
	}

}