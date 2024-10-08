import java.util.ArrayList;
import java.util.List;

public class Frota {
    private List<Veiculo> listaDeVeiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo novoVeiculo) {
        listaDeVeiculos.add(novoVeiculo);
    }

    public List<Veiculo> pesquisarPorPlaca(String placa) {
        List<Veiculo> veiculosEncontrados = new ArrayList<>();
        for (Veiculo veiculo : listaDeVeiculos) {
            if (veiculo.getModelo().toLowerCase().contains(placa.toLowerCase())) {
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
