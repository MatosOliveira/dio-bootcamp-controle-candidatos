package candidatura;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

	static double SALARIO_BASE = 2000.0;
	static String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELLA", "DANIELA", "JOSE"};
	static List<String> listaSelecionados = new ArrayList<>();
	
	public static void main(String[] args) {
		selecaoCandidatos();
		imprimirSelecionados();
		
		for(String candidato: listaSelecionados) {
			contatarCandidato(candidato);
		}
	}
	
	
	static void selecaoCandidatos() {
		
		int candidatosSelecionados = 0;
		int candidatosAtual = 0;
		
		while((candidatosSelecionados < 5) && (candidatosAtual < candidatos.length) ) {
			String candidato = candidatos[candidatosAtual];
			double salarioPretendido = getValorPretendido();
			
			System.out.println("O candidato " + candidato + " solicitou este valor de salario " + String.format("%.2f", salarioPretendido));
			if(SALARIO_BASE >= salarioPretendido) {
				//System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
				listaSelecionados.add(candidato);
				candidatosSelecionados++;
			}
			
			candidatosAtual++;
		}
	}
	
	
	static double getValorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	
	static void analisarCandidato(double salarioPretendido) {
		
		if(SALARIO_BASE > salarioPretendido) {
			System.out.println("Ligar para o candidato");
			
		} else if(SALARIO_BASE == salarioPretendido) {
			System.out.println("Ligar para o candidato com contra proposta");
			
		} else {
			System.out.println("Aguardar o resultado dos demais candidatos.");
		}
	}
	
	
	static void contatarCandidato(String candidato) {
		int tentativasRealizadas = 1;
		boolean novaTentativa = true;
		boolean chamadaAtendida = false;
		
		do {
			chamadaAtendida = atender();
			novaTentativa = !chamadaAtendida;
			
			if(novaTentativa) {
				tentativasRealizadas++;
				
			} else {
				System.out.println("Contato realizado com sucesso!");
			}
			
		} while (novaTentativa && tentativasRealizadas <= 3);
		
		if(chamadaAtendida) {
			System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa(s).");
			
		} else {
			System.out.println("Não conseguimos contato com " + candidato + ", numero maximo de tentativas " + tentativasRealizadas + " realizadas.");
		}
	}
	
	
	static void imprimirSelecionados() {
		System.out.println("\nCandidatos selecionados: ");
		for(String ls: listaSelecionados) {
			System.out.println(ls);
		}
	}
	
	//metodo auxiliar
	static boolean atender() {
		return new Random().nextInt(3) == 1;
	}

}
