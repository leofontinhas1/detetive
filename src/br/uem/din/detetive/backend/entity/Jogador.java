package br.uem.din.detetive.backend.entity;


import br.uem.din.detetive.backend.infra.Checker;

public class Jogador {
	 private String nome;
	 
	 private Integer tentativas;

	 
	public Jogador(String nome, Integer tentativas) {
		Checker.notEmpty(nome, "nome");
		Checker.positivo(tentativas, "Tentativas");
		this.nome = nome;
		this.setTentativas(tentativas);
	}

	public String getNome() {
		return nome;
	}

	public Integer getTentativas() {
		return tentativas;
	}

	public void setTentativas(Integer tentativas) {
		Checker.positivo(tentativas, "Tentativas");
		this.tentativas = tentativas;
	}
	 
	 
	



	 
}
