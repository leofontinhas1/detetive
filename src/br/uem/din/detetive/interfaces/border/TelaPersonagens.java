package br.uem.din.detetive.interfaces.border;

import br.uem.din.detetive.backend.controler.ControladorJogo;

import java.util.Scanner;




public class TelaPersonagens {

	private Scanner scan = new Scanner(System.in);
	private ControladorJogo controlador = new ControladorJogo();
	private int opcao;
	private String nome;
	
	private TelaInicial telaInicial = new TelaInicial();
	
	
	public int menuInserir(){
		System.out.println("\n\n\n");
		System.out.println("0. Voltar para Menu Inicial");
		System.out.println("1. Inserir suspeito");
		System.out.println("2. Inserir arma do crime");
		System.out.println("3. Inserir local");
		System.out.println("Digite a opcao: ");
		
		opcao = scan.nextInt();
		scan.nextLine();//para "limpar o \n do buffer"
		return opcao;
	}

	private void inserirArma() {
		System.out.println("Insira o nome da arma: ");
		nome=scan.nextLine();
		scan.nextLine();
		controlador.novaArma(nome);		
		System.out.println("Arma inserida com sucesso");
	}

	private void inserirSuspeito() {
		System.out.println("Insira o nome do suspeito: ");
		nome=scan.nextLine();
		scan.nextLine();
		controlador.novoSuspeito(nome);		
		System.out.println("Suspeito inserido com sucesso");
	}

	private void inserirLocal() {
		System.out.println("Insira o nome do local: ");
		nome=scan.nextLine();
		scan.nextLine();
		controlador.novoLocal(nome);		
		System.out.println("Local inserido com sucesso");
	}
	
	public int menuConsultar() {
		System.out.println("\n\n\n");
		System.out.println("0. Voltar para Menu Inicial");
		System.out.println("1. Consultar suspeito");
		System.out.println("2. Consultar arma do crime");
		System.out.println("3. Consultar local");
		System.out.println("Digite a opcao: ");
		opcao = scan.nextInt();
		scan.nextLine();//para "limpar o \n do buffer"
		return opcao;
	}
	public void consultarSuspeitos() {
		for (int i = 0; i < controlador.getSuspeitos().size(); i++) {
			System.out.println("| "+controlador.getSuspeitos().get(i).getNome());
		}
	}
	public void consultarArmas() {
		for (int i = 0; i < controlador.getArmas().size(); i++) {
			System.out.println("| "+controlador.getArmas().get(i).getNome());
		}
	}
	public void consultarLocais() {
		for (int i = 0; i < controlador.getLocais().size(); i++) {
			System.out.println("| "+controlador.getLocais().get(i).getNome());
		}
	}
	
	public int menuRemover() {
		System.out.println("\n\n\n");
		System.out.println("0. Voltar para Menu Inicial");
		System.out.println("1. Remover suspeito");
		System.out.println("2. Remover arma do crime");
		System.out.println("3. Remover local");
		System.out.println("Digite a opcao: ");
		opcao = scan.nextInt();
		scan.nextLine();//para "limpar o \n do buffer"
		return opcao;
	}
	public void removeArma() {
		System.out.println("Insira o nome da arma que deseja remover: ");
		nome=scan.nextLine();
		scan.nextLine();
		controlador.removeArma(nome);
		System.out.println("Arma removida com sucesso");
	}
	public void removeSuspeito() {
		System.out.println("Insira o nome do suspeito que deseja remover: ");
		nome=scan.nextLine();
		scan.nextLine();
		controlador.removeSuspeito(nome);
		System.out.println("Suspeito removido com sucesso");
	}
	public void removeLocal() {
		System.out.println("Insira o nome do local que deseja remover: ");
		nome=scan.nextLine();
		scan.nextLine();
		controlador.removeLocal(nome);
		System.out.println("local removida com sucesso");
	}
	public void iniciar(Crud opcao) {
		
		if(opcao==Crud.INSERIR) {
			do{
				this.opcao = menuInserir();
				switch (this.opcao){
					case 1: inserirSuspeito(); break;
					case 2: inserirArma(); break;
					case 3: inserirLocal(); break;
				}
			}while(this.opcao != 0);
			telaInicial.iniciar();
		}
		else if(opcao==Crud.CONSULTAR) {
			do{
				this.opcao = menuConsultar();
				switch (this.opcao){
					case 1: consultarSuspeitos(); break;
					case 2: consultarArmas(); break;
					case 3: consultarLocais(); break;
				}
			}while(this.opcao != 0);
			telaInicial.iniciar();
		}
		else if(opcao==Crud.REMOVER) {
			do{
				this.opcao = menuRemover();
				switch (this.opcao){
					case 1: removeSuspeito(); break;
					case 2: removeArma(); break;
					case 3: removeLocal(); break;
				}
			}while(this.opcao != 0);
			telaInicial.iniciar();
		}
		
		
	}
}
