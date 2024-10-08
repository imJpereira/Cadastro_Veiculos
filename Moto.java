public class Moto extends Veiculo{
    private int cilindradas;

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        String descricao = super.toString();
        return descricao + " - Cilindradas: " + this.getCilindradas()+"\n";
    }
}