package br.com.cadastroapi.controller.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import br.com.cadastroapi.modelo.Genero;
import br.com.cadastroapi.modelo.Pessoa;

public class PessoaForm {

	@NotBlank
	private String nome;
	@NotBlank @CPF
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
		return preenchePessoa(new Pessoa());
	}
	
	public void atualizar(Pessoa pessoa) {
		preenchePessoa(pessoa);
	}
	
	private Pessoa preenchePessoa(Pessoa pessoa) {
		pessoa.setCpf(this.cpf);
		pessoa.setDataNascimento(LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		pessoa.setNome(this.nome);
		pessoa.setSexo(Genero.valueOf(sexo.toUpperCase().replaceAll(" ", "_")));
		return pessoa;
	}

}
