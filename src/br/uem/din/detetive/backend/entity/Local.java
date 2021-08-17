package br.uem.din.detetive.backend.entity;

import br.uem.din.detetive.backend.infra.Checker;


public class Local {

	private StatusPersonagem status;
	
	private String nome;
	
	public Local(String nome) {
		Checker.notEmpty(nome, "nome");
		setStatus(StatusPersonagem.ATIVO);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public StatusPersonagem getStatus() {
		return status;
	}

	public void setStatus(StatusPersonagem status) {
		this.status = status;
	}
	public Boolean isAtivo() {
		return status==StatusPersonagem.ATIVO;
	}
	
}
