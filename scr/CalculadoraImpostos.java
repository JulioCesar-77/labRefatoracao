public class CalculadoraImpostos {

    private static final double LIMITE_PRODUTO_CARO = 100.0;
    private static final double IMPOSTO_PRODUTO_CARO = 0.15;
    private static final double IMPOSTO_PRODUTO_BARATO = 0.05;

    private double total;
    private double impostos;
    private double[] valor;
    private int[] qtd;

    public CalculadoraImpostos(double[] valor, int[] qtd) {
        this.valor = valor;
        this.qtd = qtd;
    }

    public void calcular() {

        for (int i = 0; i < valor.length; i++) {
            double sub = valor[i] * qtd[i];
            total += sub;

            // Code Smell: Números mágicos espalhados (Ajustado) e lógica duplicada
            if (valor[i] > LIMITE_PRODUTO_CARO) {
                impostos += sub * IMPOSTO_PRODUTO_CARO; // 15% de imposto para produtos caros
            } else {
                impostos += sub * IMPOSTO_PRODUTO_BARATO; // 5% de imposto para produtos baratos
            }
        }
    }

    public double getTotal() {
        return total;
    }

    public double getImpostos() {
        return impostos;
    }
}
