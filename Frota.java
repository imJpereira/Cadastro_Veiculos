import java.util.ArrayList;
import java.util.List;

public class Frota {
    private List<Veiculo> listaDeVeiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo novoVeiculo) throws Exception {
        validarVeiculo(novoVeiculo);

        for (Veiculo veiculo : listaDeVeiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(novoVeiculo.getPlaca())) {
                throw new Exception("Erro: Já existe um veículo cadastrado com essa placa.");
            }
        }

        listaDeVeiculos.add(novoVeiculo);
    }

    private static void validarVeiculo(Veiculo veiculo) throws Exception {
        if (veiculo.getMarca() == null || veiculo.getMarca().isBlank()) {
            throw new Exception("Erro: O campo 'Marca' não pode estar vazio.");
        }
        if (veiculo.getModelo() == null || veiculo.getModelo().isBlank()) {
            throw new Exception("Erro: O campo 'Modelo' não pode estar vazio.");
        }
        if (veiculo.getPlaca() == null || veiculo.getPlaca().isBlank()) {
            throw new Exception("Erro: O campo 'Placa' não pode estar vazio.");
        }
        if (veiculo.getAno() <= 1800) {
            throw new Exception("Erro: O ano do veículo deve ser maior que 1800.");
        }
        if (veiculo instanceof Carro && ((Carro) veiculo).getNumeroPortas() <= 0) {
            throw new Exception("Erro: O número de portas do carro deve ser maior que zero.");
        }
    }

    public List<Veiculo> pesquisarPorPlaca(String placa) {
        List<Veiculo> veiculosEncontrados = new ArrayList<>();
        for (Veiculo veiculo : listaDeVeiculos) {
            if (veiculo.getPlaca().toLowerCase().contains(placa)) {
                veiculosEncontrados.add(veiculo);
            }
        }

        return veiculosEncontrados;
    }

    public Boolean removerPorPlaca(String placa) {
        for (Veiculo veiculo : listaDeVeiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                listaDeVeiculos.remove(veiculo);
                return true;
            }
        }
        return false;
    }

    public List<Veiculo> pesquisarTodos() {
        return this.listaDeVeiculos;
    }
}
