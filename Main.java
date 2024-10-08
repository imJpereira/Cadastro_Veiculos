import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
			limparTela();
			System.out.println(menu);
			opcao = inputNumInteiro("Sua escolha: ");
		
			switch (opcao) {
				case 1:
					adicionarVeiculo();
					break;
				case 2:
					pesquisarTodos();
					break;
				case 3: 
					pesquisarMarca();
					break;
				case 4:
					removerVeiculo();
					break;
				default:
					break;
				}
		}


		input.close(); 				
	}	

	public static void adicionarVeiculo() {
		limparTela();
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
					break;
				case 3: // Caminhão
					veiculo = new Caminhao();
					break;
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

		if (veiculo instanceof Moto) {
			((Moto) veiculo).setCilindradas(inputNumInteiro("Cilindradas: "));
		} else if (veiculo instanceof Carro) {
			((Carro) veiculo).setNumeroPortas(inputNumInteiro("Número de Portas: "));
		} else if (veiculo instanceof Caminhao) {
			((Caminhao) veiculo).setCapacidade(inputNumInteiro("Capacidade: "));
		}

		//frota.adicionarVeiculo(veiculo);
	}

	public static void listarVeiculos(List<Veiculo> listaVeiculos) {
		limparTela();
		listaVeiculos.sort(Comparator.comparing(Veiculo::getMarca));
		for (Veiculo veiculo : listaVeiculos) {
			System.out.println(veiculo);
		}
		travarAcao();
	}

	public static void pesquisarTodos() {
		var listaVeiculos = frota.pesquisarTodos();
		listarVeiculos(listaVeiculos);
	}

	public static void pesquisarMarca() {
		limparTela();
        System.out.print("Marca do Veículo: ");
        String marca = input.nextLine();
        List<Veiculo> veiculosEncontrados = new ArrayList<>();

        // try {
        //      veiculosEncontrados = frota.pesquisarPorTitulo(marca);
        // } catch (Exception e) {
        //     System.out.println("Erro ao procurar esse veículo: " + e.getMessage());
        // }

        listarVeiculos(veiculosEncontrados);
	}	

	public static void removerVeiculo() {
		limparTela();
		System.out.print("Placa do Veículo: ");
		String placa = input.nextLine();

		try {
			frota.removerPorPlaca(placa);
			System.out.println("Veículo removido com sucesso! ");
		} catch (Exception e) {
			System.out.println("Não foi possível remover livro \n" + e.getMessage());
		}

		travarAcao();
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
