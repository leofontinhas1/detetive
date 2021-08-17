package br.uem.din.detetive.backend.controler;


import br.uem.din.detetive.backend.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ControladorJogo {

	private List<Arma> armas =new ArrayList<>();
	
	private List<Local> locais = new ArrayList<>();

	private List<Suspeito> suspeitos = new ArrayList<>();
	
	private List<Jogador> jogadores = new ArrayList<>();
	
	private Crime crime;
	
	public void reiniciarGame() {
		removeJogoPadrao();
		for (int i = 0; i < armas.size(); i++) {
			if(armas.get(i).isAtivo()) {
				armas.get(i).setStatus(StatusPersonagem.INATIVO);
			}
			
		}
		for (int i = 0; i < suspeitos.size(); i++) {
			if(suspeitos.get(i).isAtivo()) {
				suspeitos.get(i).setStatus(StatusPersonagem.INATIVO);
			}
		}
		for (int i = 0; i < locais.size(); i++) {
			if(locais.get(i).isAtivo()) {
				locais.get(i).setStatus(StatusPersonagem.INATIVO);
			}
		}
	}
	public void jogoPersonalizado() {
		removeJogoPadrao();
		for (int i = 0; i < armas.size(); i++) {
			if(armas.get(i).isAtivo()) {
				armas.get(i).setStatus(StatusPersonagem.ATIVO);
			}
			
		}
		for (int i = 0; i < suspeitos.size(); i++) {
			if(suspeitos.get(i).isAtivo()) {
				suspeitos.get(i).setStatus(StatusPersonagem.ATIVO);
			}
		}
		for (int i = 0; i < locais.size(); i++) {
			if(locais.get(i).isAtivo()) {
				locais.get(i).setStatus(StatusPersonagem.ATIVO);
			}
		}
	}
	public void jogoMisto() {
		jogoPersonalizado();
		jogoPadrao();
	}
	public  void jogoPadrao() {

		//add armas\\
		novaArma("Castiçal");
		novaArma("Cano");
		novaArma("Chave inglesa");
		novaArma("Corda");
		novaArma("Revólver");
		novaArma("Faca");
		
		//add suspeitos\\
		novoSuspeito("Coronel Mustard");
		novoSuspeito("Dona Branca");
		novoSuspeito("Senhora Pavão");
		novoSuspeito("Professor Plum");
		novoSuspeito("Reverendo Sr. Green");
		novoSuspeito("Senhorita Scarlett");
		
		//add locais\\		
		novoLocal("Biblioteca");
		novoLocal("Cozinha");
		novoLocal("Hall");
		novoLocal("Escritório");
		novoLocal("Sala de estar");
		novoLocal("Sala de musica");
		novoLocal("Salão de festas");
		novoLocal("Salão de jogos");
		novoLocal("Sala de jantar");
		
	}
	public  void removeJogoPadrao() {

		//remove armas\\
		removeArma("Castçal");
		removeArma("Cano");
		removeArma("Chave inglesa");
		removeArma("Corda");
		removeArma("Revólver");
		removeArma("Faca");
				
		//remove suspeitos\\
		removeSuspeito("Coronel Mustard");
		removeSuspeito("Dona Branca");
		removeSuspeito("Senhora Pavão");
		removeSuspeito("Professor Plum");
		removeSuspeito("Reverendo Sr. Green");
		removeSuspeito("Senhorita Scarlett");
		
		//remove locais\\		
		removeLocal("Biblioteca");
		removeLocal("Cozinha");
		removeLocal("Hall");
		removeLocal("Escritório");
		removeLocal("Sala de estar");
		removeLocal("Sala de musica");
		removeLocal("Salão de festas");
		removeLocal("Salão de jogos");
		removeLocal("Sala de jantar");
		
	}
	
	public void gerarCrime() {
		List<Arma> armasAtivas =new ArrayList<>();
		
		List<Local> locaisAtivos = new ArrayList<>();

		List<Suspeito> suspeitosAtivos = new ArrayList<>();
		for (int i = 0; i < armas.size(); i++) {
			if(armas.get(i).isAtivo()) {
				armasAtivas.add(armas.get(i));
			}
		}
		Integer randomArmas = ThreadLocalRandom.current().nextInt(armasAtivas.size()) % armasAtivas.size();
		
		for (int i = 0; i < locais.size(); i++) {
			if(locais.get(i).isAtivo()) {
				locaisAtivos.add(locais.get(i));
			}
		}
		Integer randomLocais = ThreadLocalRandom.current().nextInt(locaisAtivos.size()) % locaisAtivos.size();
		
		for (int i = 0; i < suspeitos.size(); i++) {
			if(suspeitos.get(i).isAtivo()) {
				suspeitosAtivos.add(suspeitos.get(i));
			}
		}
		Integer randomSuspeitos = ThreadLocalRandom.current().nextInt(suspeitosAtivos.size()) % suspeitosAtivos.size();

		Crime crime= new Crime(locaisAtivos.get(randomLocais), armasAtivas.get(randomArmas), suspeitosAtivos.get(randomSuspeitos));
		
		this.crime=crime;
	}
	
	public void novoJogador(String nome) {
		
		Jogador player = new Jogador(nome, 1);
		
		jogadores.add(player);
	}
	public void novaArma(String nome) {
		this.armas.add(new Arma(nome));
	}
	public void novoSuspeito(String nome) {
		this.suspeitos.add(new Suspeito(nome));
	}
	public void novoLocal(String nome) {
		this.locais.add(new Local(nome));
	}
	public void removeJogador(String nome) {
		for (int i = 0; i < jogadores.size(); i++) {
			if(jogadores.get(i).getNome().equals(nome)) {
				jogadores.remove(i);
			}
		}	
	}
	public void removeArma(String nome) {
		for (int i = 0; i < armas.size(); i++) {
			if(armas.get(i).getNome().equals(nome)) {
				armas.remove(i);
			}
		}	
	}
	public void removeSuspeito(String nome) {
		for (int i = 0; i < suspeitos.size(); i++) {
			if(suspeitos.get(i).getNome().equals(nome)) {
				suspeitos.remove(i);
			}
		}	
	}
	public void removeLocal(String nome) {
		for (int i = 0; i < locais.size(); i++) {
			if(locais.get(i).getNome().equals(nome)) {
				locais.remove(i);
			}
		}	
	}
	
	public Boolean palpiteArma(Jogador player,Arma arma) {
		if(!(arma == crime.getArma())) {
			player.setTentativas(player.getTentativas()-1);
			return false;
		}
		return true;
	}
	public Boolean palpiteSuspeito(Jogador player,Suspeito suspeito) {
		if(!(suspeito == crime.getCriminoso())) {
			player.setTentativas(player.getTentativas()-1);
			return false;
		}
		return true;
	}
	public Boolean palpiteLocal(Jogador player,Local local) {
		if(!(local== crime.getLocal())) {
			player.setTentativas(player.getTentativas()-1);
			return false;
		}
		return true;
	}
		
	public void definirDificuldade (Dificuldade nivel) {
		if(nivel== Dificuldade.FACIL) {
			for (Jogador jogadore : jogadores) {
				jogadore.setTentativas(10);
			}
		}
		else if(nivel== Dificuldade.MEDIO) {
			for (Jogador jogadore : jogadores) {
				jogadore.setTentativas(5);
			}
		}
		else if(nivel== Dificuldade.DIFICIL) {
			for (Jogador jogadore : jogadores) {
				jogadore.setTentativas(3);
			}
		}
	}
	public Boolean acusacaoIsTrue(Jogador player,Boolean arma,Boolean local,Boolean suspeito) {
		if(arma && suspeito && local) {
			player.setTentativas(player.getTentativas()-1);
			return true;
		}
		return false;
	}
	
	public List<Arma> getArmas() {
		return armas;
	}
	public List<Local> getLocais() {
		return locais;
	}
	public List<Suspeito> getSuspeitos() {
		return suspeitos;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	
}
