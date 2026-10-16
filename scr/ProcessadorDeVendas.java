public class ProcessadorDeVendas {

    private Cliente cliente;
    private EstrategiaFrete estrategiaFrete;

    private double[] valor;
    private int[] qtd;

    private double frete;
    private double impostos;
    private double total;
    private double totalFinal;

    public ProcessadorDeVendas(
            Cliente cliente,
            double[] valor,
            int[] qtd,
            EstrategiaFrete estrategiaFrete) {

        this.cliente = cliente;
        this.valor = valor;
        this.qtd = qtd;
        this.estrategiaFrete = estrategiaFrete;
    }

    public void processar() {
        if (cliente == null || !cliente.isDocumentoValido()) {
            System.out.println("Erro: Documento invalido.");
            return;
        }

        CalculadoraImpostos calculadoraImpostos = new CalculadoraImpostos(valor, qtd);

        calculadoraImpostos.calcular();

        total = calculadoraImpostos.getTotal();
        impostos = calculadoraImpostos.getImpostos();

        frete = estrategiaFrete.calcularFrete(cliente);

        totalFinal = total + impostos + frete;

        ImpressoraRecibo impressora = new ImpressoraRecibo();
        impressora.exibir(
                cliente.getNome(),
                cliente.getDocumento(),
                total,
                impostos,
                frete,
                totalFinal);
    }
}
