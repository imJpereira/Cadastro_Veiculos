import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);
	static Frota frota = new Frota();	

	public static void main(String[] args) {
		String menu = """

		======= CADASTRO DE VEÍCULO =======
		Escolha uma das opções:
        1- Adicionar novo veículo;
        2- Listar todos os veículos;
        3- Pesquisar veículo;
        4- Remover veículo;
        0- Sair;

		""";

		int opcao = -1; 

		while (opcao != 0) {

			opcao = inputNumInteiro("Sua escolha: ");
		}

		input.close(); 				
	}	

	private static int inputNumInteiro(String mensagem) {
		int valorNumerico = 0;
        	Boolean inputNumerico = false;
        
        	while(!inputNumerico) {
            		System.out.print(mensagem);
            		String inputStr = input.nextLine();
            		try {
                		valorNumerico = Integer.parseInt(inputStr);
                		inputNumerico = true;
            		} catch (Exception e) {
                		System.out.println("Por favor, digite um número inteiro! "+ e.getMessage());
            		}	
        	}		
        	return valorNumerico;
	}

	private static void limparTela() {
        	System.out.println("\033[H\033[2J");
    	}

    	private static void travarAcao() {
        	System.out.print("Clique qualquer tecla para prosseguir: ");
        	input.nextLine();
    	}

}
