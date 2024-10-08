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
        String descrição = super.toString();
        return descrição + "Capacidade: " + this.getCapacidade();
    }
}
