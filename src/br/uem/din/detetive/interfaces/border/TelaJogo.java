package br.uem.din.detetive.interfaces.border;

import br.uem.din.detetive.backend.controler.ControladorJogo;
import br.uem.din.detetive.backend.controler.Dificuldade;
import br.uem.din.detetive.backend.entity.Arma;
import br.uem.din.detetive.backend.entity.Jogador;
import br.uem.din.detetive.backend.entity.Local;
import br.uem.din.detetive.backend.entity.Suspeito;

import java.util.Scanner;

public class TelaJogo {

	private Scanner scan = new Scanner(System.in);
	private ControladorJogo controlador = new ControladorJogo();
	private int opcao;
	private String nome;
	private TelaInicial telaInicial = new TelaInicial();
	private int jogador;
	private int palpite;
	private Boolean suspeitoCerto=false;
	private Boolean armaCerta=false;
	private Boolean localCerto=false;
	
	
	
	
	
	public int numeroJogadores() {
		System.out.println("Quantos jogadores v�o participar do jogo?(maximo 6)");
		opcao = scan.nextInt();
		scan.nextLine();
		if(opcao < 1||opcao > 6) {
			System.out.println("|||ATEN��O|||\n\nMinimo 1 jogador\nMaximo 6 jogadores");
			opcao=numeroJogadores();
		}		
		return opcao;
	}
	
	public void novosJogadores(int quantidade) {
		for (int i = 0; i < quantidade; i++) {
			System.out.println("Digite o nome do jogador n"+(i+1));
			nome = scan.nextLine();
			//scan.nextLine();
			controlador.novoJogador(nome);
		}
	}
	
	public int dificudadeJogo() {
		System.out.println("Escolha um nivel de dificuldade");
		System.out.println("1|Facil");
		System.out.println("2|Medio");
		System.out.println("3|Dificil");
		System.out.println("Digite um numero:");
		opcao = scan.nextInt();
		//scan.nextLine();
		if(opcao < 1||opcao > 3) {
			System.out.println("|||ATEN��O|||\n\nInsira um valor entre 1 e 3");
			opcao=dificudadeJogo();
		}
		
		if(opcao==1) {
			controlador.definirDificuldade(Dificuldade.FACIL);
		}else if(opcao==2) {
			controlador.definirDificuldade(Dificuldade.MEDIO);
		}else if(opcao==3) {
			controlador.definirDificuldade(Dificuldade.DIFICIL);
		}
		return opcao;
	}
	
	public int menu(int jogador) {
		nome = controlador.getJogadores().get(jogador).getNome();
		if(controlador.getJogadores().get(jogador).getTentativas()==0) {
			System.out.println("Jogador "+nome + " ficou sem tentativas");
			return opcao=5;
		}
		
		System.out.println("\n\n"+nome+" sua vez de dar um palpite!");
		System.out.println("1-Palpite Suspeito");
		System.out.println("2-Palpite Arma");
		System.out.println("3-Palpite Local");
		System.out.println("4-Fazer Acusa��o");
		System.out.println("Digite a op��o : ");
		opcao = scan.nextInt();
		scan.nextLine();
		return opcao;
	}
	
	private void palpiteSuspeito(int jogador) {
		System.out.println("\n//Suspeitos do Crime\\\n");
		int cont=0;
		for (int i = 0; i < controlador.getSuspeitos().size(); i++) {
			if(controlador.getSuspeitos().get(i).isAtivo()) {
				cont++;
				System.out.println("| "+cont+"-"+controlador.getSuspeitos().get(i).getNome());
			}
		}
		System.out.println("\nQual � o seu palpite?");
		palpite=scan.nextInt();
		//scan.nextLine();
		cont=0;
		for (int i = 0; i < controlador.getSuspeitos().size(); i++) {
			if(controlador.getSuspeitos().get(i).isAtivo()) {
				cont++;
				if(cont==palpite) {
					Jogador player = controlador.getJogadores().get(jogador);
					Suspeito suspeito =controlador.getSuspeitos().get(i);
					
					if(controlador.palpiteSuspeito(player, suspeito)) {
						System.out.println("Parab�ns voc� acertou!!");
						suspeitoCerto=true;
					}else {
						System.out.println("Voc� errou :(");
						suspeitoCerto=false;
					}
				}
				
			}
		}
	}
	
	
	private void palpiteArma(int jogador) {

		int cont=0;
		System.out.println("\n//Armas Do Crime\\\n");
		
		for (int i = 0; i < controlador.getArmas().size(); i++) {
			if(controlador.getArmas().get(i).isAtivo()) {
				cont++;
				System.out.println("| "+cont+"-"+controlador.getArmas().get(i).getNome());
			}
		}
		System.out.println("\nQual � o seu palpite?");
		palpite=scan.nextInt();
		scan.nextLine();
		cont=0;
		for (int i = 0; i < controlador.getArmas().size(); i++) {
			if(controlador.getArmas().get(i).isAtivo()) {
				cont++;
				if(cont==palpite) {
					Jogador player = controlador.getJogadores().get(jogador);
					Arma arma =controlador.getArmas().get(i);
					
					if(controlador.palpiteArma(player, arma)) {
						System.out.println("Parab�ns voc� acertou!!");
						armaCerta=true;
					}else {
						System.out.println("Voc� errou :(");
						armaCerta=false;
					}
				}
				
			}
		}
	}
	
	
	private void palpiteLocal(int jogador) {
		int cont=0;
		System.out.println("\n//Locais Do Crime\\\n");
		
		for (int i = 0; i < controlador.getLocais().size(); i++) {
			if(controlador.getLocais().get(i).isAtivo()) {
				cont++;
				System.out.println("| "+cont+"-"+controlador.getLocais().get(i).getNome());
			}
		}
		System.out.println("\nQual � o seu palpite?");
		palpite=scan.nextInt();
		scan.nextLine();
		cont=0;
		for (int i = 0; i < controlador.getLocais().size(); i++) {
			if(controlador.getLocais().get(i).isAtivo()) {
				cont++;
				if(cont==palpite) {
					Jogador player = controlador.getJogadores().get(jogador);
					Local local =controlador.getLocais().get(i);
					
					if(controlador.palpiteLocal(player, local)) {
						System.out.println("Parab�ns voc� acertou!!");
						localCerto=true;
					}else {
						System.out.println("Voc� errou :(");
						localCerto=false;
					}
				}
				
			}
		}
		
	}
	
	public void acusacao(int jogador) {
		System.out.println("\n\n"+nome+" qual � a sua acusa��o?");
		palpiteSuspeito(jogador);
		palpiteArma(jogador);
		palpiteLocal(jogador);
		Jogador player = controlador.getJogadores().get(jogador);
		if(controlador.acusacaoIsTrue(player, armaCerta, localCerto, suspeitoCerto)) {
			System.out.println("Parabens!!");
			System.out.println("Jogador "+nome+" venceu o jogo");
			System.out.println("\n\n\n-----|| FIM DE JOGO ||-----");
			opcao = 0;
		}
		else {
			System.out.println("Voc� errou :(");
		}
	}
	
	public void jogadas(int jogador) {	
		int cont=0;
		for (int i = 0; i < controlador.getJogadores().size(); i++) {
			if(controlador.getJogadores().get(i).getTentativas()<=0) {
				cont++;
			}
		}
		if(cont==controlador.getJogadores().size()) {
			opcao=0;
			System.out.println("Todos os jogadores ficaram sem jogada!!");
			System.out.println("\n\n\n-----|| FIM DE JOGO ||-----");
		}
	}
	
	public void iniciar(TipoDeJogo tipoDeJogo) {
		int numPlayers = numeroJogadores();
		novosJogadores(numPlayers);
		opcao = dificudadeJogo();
		if(tipoDeJogo == TipoDeJogo.PADRAO) {
			controlador.reiniciarGame();
			controlador.jogoPadrao();
			controlador.gerarCrime();
		}
		else if (tipoDeJogo == TipoDeJogo.PERSONALIZADO) {
			controlador.reiniciarGame();
			controlador.jogoPersonalizado();
			controlador.gerarCrime();
		}
		else if(tipoDeJogo == TipoDeJogo.MISTO) {
			controlador.reiniciarGame();
			controlador.jogoMisto();
			controlador.gerarCrime();
		}
		
		
		jogador=0;
		do{
			opcao = menu(jogador);
			switch (this.opcao){
				case 1: palpiteSuspeito(jogador); break;
				case 2: palpiteArma(jogador); break;
				case 3: palpiteLocal(jogador); break;
				case 4: acusacao(jogador);break;
				case 5: jogadas(jogador);break;
			}
			jogador++;
			if(jogador==numPlayers) {
				jogador=0;
			}
		}while(this.opcao != 0);
		telaInicial.iniciar();
		
	}
		
}
