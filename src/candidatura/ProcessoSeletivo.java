package candidatura;

public class ProcessoSeletivo {

	static double SALARIO_BASE = 2000.0;
	
	public static void main(String[] args) {
		analisarCandidato(1900.0);
		analisarCandidato(2000.0);
		analisarCandidato(2500.0);
	}
	
	static void selecaoCandidatos() {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELLA", "DANIELA", "JOSE"};
		
		int candidatosSelecionados = 0;
		int candidatosAtual = 0;
		
		while(candidatosSelecionados < 5) {
			String candidato = candidatos[candidatosAtual];
		}
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

}
