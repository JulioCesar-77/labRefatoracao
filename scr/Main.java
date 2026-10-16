public class Main {
    public static void main(String[] args) {
        double[] valores = { 50.0, 150.0, 30.0 };
        int[] quantidades = { 2, 1, 3 };

        Cliente cliente = new Cliente(
                "João Silva",
                "12345678901",
                1,
                "SP");

        ProcessadorDeVendas processador = new ProcessadorDeVendas(
                cliente,
                valores,
                quantidades,
                new FreteVipStrategy());

        processador.processar();
    }
}