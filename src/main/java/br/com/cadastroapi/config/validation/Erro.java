package br.com.cadastroapi.config.validation;

public class Erro {

	private String erro;
	private String campo;

	public Erro(String erro, String campo) {
		super();
		this.erro = erro;
		this.campo = campo;
	}

	public String getErro() {
		return erro;
	}

	public String getCampo() {
		return campo;
	}

}
