public class Caminhao extends Veiculo {
    private int capacidade;

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        String descricao = super.toString();
        return descricao + " - Capacidade: " + this.getCapacidade()+"\n";
    }
}
