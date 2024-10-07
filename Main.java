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
			System.out.println(menu);
			opcao = inputNumInteiro("Sua escolha: ");
		
			switch (opcao) {
				case 1:
					adicionarVeiculo();
					break;
				case 2:
					// listarTodos();
					break;
				case 3: 
					// pesquisarNome();
					break;
				case 4:
					// removerVeiculo();
					break;
				default:
					break;
				}
		}


		input.close(); 				
	}	

	public static void adicionarVeiculo() {
		Veiculo veiculo = null;
		
		while (veiculo == null) {

			System.out.println("""
				Qual é o Veículo?
				1- Moto
				2- Carro
				3- Caminhão	
				""");
			int tipoVeiculo = inputNumInteiro("Sua escolha: ");

			switch (tipoVeiculo) {
				case 1: // Moto
					veiculo = new Moto();
					break;
				case 2: // Carro
					veiculo = new Carro();
				case 3: // Caminhão
					veiculo = new Caminhao();
				default:
					break;
			}
		}

		System.out.print("Marca: ");
		veiculo.setMarca(input.nextLine());

		System.out.print("Modelo: ");
		veiculo.setModelo(input.nextLine());

		System.out.print("Placa: ");
		veiculo.setPlaca(input.nextLine());

		veiculo.setAno(inputNumInteiro("Ano: "));

		frota.adicionarLivro(veiculo);

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
