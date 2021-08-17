package br.uem.din.detetive.backend.entity;


import br.uem.din.detetive.backend.infra.Checker;

public class Crime {
	
	private Local local;
	
	private Arma arma;
	
	private Suspeito criminoso;

	
	
	
	public Crime(Local local, Arma arma, Suspeito criminoso) {
		Checker.notNull(local, "local");
		Checker.notNull(criminoso, "criminoso");
		Checker.notNull(arma, "arma");
		this.local = local;
		this.arma = arma;
		this.criminoso = criminoso;
	}

	public Local getLocal() {
		return local;
	}

	public Arma getArma() {
		return arma;
	}

	public Suspeito getCriminoso() {
		return criminoso;
	}
	
	

}
