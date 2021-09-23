package br.com.cadastroapi.controller.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;

import br.com.cadastroapi.modelo.Genero;
import br.com.cadastroapi.modelo.Pessoa;

public class PessoaForm {

	@NotBlank
	private String nome;
	@NotBlank
	private String cpf;
	@NotBlank
	private String dataNascimento;
	@NotBlank
	private String sexo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Pessoa converter() {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(this.cpf);
		
		pessoa.setDataNascimento(LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		pessoa.setNome(this.nome);
		pessoa.setSexo(Genero.valueOf(sexo.toUpperCase()));
		return pessoa;
	}
	
	public void atualizar(Pessoa pessoa) {
		pessoa.setCpf(this.cpf);
		pessoa.setDataNascimento(LocalDate.parse(dataNascimento));
		pessoa.setNome(this.nome);
		pessoa.setSexo(Genero.valueOf(sexo.toUpperCase()));
	}

}
