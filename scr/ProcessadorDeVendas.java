public class ProcessadorDeVendas {

    private static final int TAMANHO_DOCUMENTO = 11;

    private String numCliente;
    private String documento;
    private int tipoCliente;
    private String endereco;
    private double[] valor;
    private int[] qtd;

    private double frete;
    private double impostos;
    private double total;
    private double totalFinal;

    public ProcessadorDeVendas(
            String numCliente,
            String documento,
            int tipoCliente,
            String endereco,
            double[] valor,
            int[] qtd) {

        this.numCliente = numCliente;
        this.documento = documento;
        this.tipoCliente = tipoCliente;
        this.endereco = endereco;
        this.valor = valor;
        this.qtd = qtd;
    }

    public void processar() {
        if (documento == null || documento.length() != TAMANHO_DOCUMENTO) {
            System.out.println("Erro: Documento invalido.");
            return;
        }

        CalculadoraImpostos calculadoraImpostos = new CalculadoraImpostos(valor, qtd);

        calculadoraImpostos.calcular();

        total = calculadoraImpostos.getTotal();
        impostos = calculadoraImpostos.getImpostos();

        CalculadoraFrete calculadoraFrete = new CalculadoraFrete();
        frete = calculadoraFrete.calcular(tipoCliente, endereco);

        totalFinal = total + impostos + frete;

        ImpressoraRecibo impressora = new ImpressoraRecibo();
        impressora.exibir(
                numCliente,
                documento,
                total,
                impostos,
                frete,
                totalFinal
        );
    }
}
