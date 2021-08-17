package br.uem.din.detetive.backend.infra;



public class Checker {
	
	public static void notNull(Object nome,String campo) {
		if(nome==null) {
			throw new RuntimeException("Campo "+campo+" é Obrigatorio");
		}
	}
	public static void notEmpty(String nome,String campo) {
		notNull(nome, campo);
		if(nome.isEmpty()) {
			throw new RuntimeException("Campo "+campo+" esta vazio");
		}
	}
	public static void lengthMin(String nome,String campo,int valor) {
		if(nome.replaceAll(" ", "").length()<valor) {
			throw new RuntimeException("Campo "+campo+" precisa ter no minimo "+valor+"caracteres");
		}
	}
	public static void positivo(Integer tentativas,String campo) {
		if(tentativas<=0) {
			throw new RuntimeException("Campo "+campo+" precisa ter um valor positivo");
		}
	}
}
