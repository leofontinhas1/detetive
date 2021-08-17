package br.uem.din.detetive.interfaces.border;

import java.util.Scanner;

public class TelaInicial {
	 
	private Scanner scan = new Scanner(System.in);
	
	private int opcao;
	
	public int menuInicial(){
		System.out.println("\n");
		System.out.println("0. Sair");
		System.out.println("1. Inserir suspeito/arma do crime/local");
		System.out.println("2. Consultar suspeito/arma do crime/local");
		System.out.println("3. Excluir suspeito/arma do crime/local");
		System.out.println("4. Jogar Jogo Padr�o(todos os personagens s�o os padr�es do sistema)");
		System.out.println("5. Jogar Jogo Personalizado(todos os personagens s�o os inseridos pelo usuario)");
		System.out.println("6. Jogar Jogo Misto(todos os personagens s�o os padr�es do sistema, e os inseridos pelo usuario )");
		System.out.println("Digite a opcao: ");
	
		opcao = scan.nextInt();
		scan.nextLine();//para "limpar o \n do buffer"
		return opcao;
	}
	
	
	public void iniciar(){
		TelaPersonagens telaPersonagens = new TelaPersonagens();
		TelaJogo jogo = new TelaJogo();
		do{
			opcao = menuInicial();
			switch (opcao){
				case 1: telaPersonagens.iniciar(Crud.INSERIR); break;
				case 2: telaPersonagens.iniciar(Crud.CONSULTAR); break;
				case 3: telaPersonagens.iniciar(Crud.REMOVER); break;
				case 4: jogo.iniciar(TipoDeJogo.PADRAO); break;
				case 5: jogo.iniciar(TipoDeJogo.PERSONALIZADO); break;
				case 6: jogo.iniciar(TipoDeJogo.MISTO); break;
			}
		}while(opcao != 0);
	}
}
