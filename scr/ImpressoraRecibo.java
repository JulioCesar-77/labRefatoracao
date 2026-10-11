import java.util.Date;

public class ImpressoraRecibo {

    public void exibir(
            String nomeCliente,
            String documento,
            double subtotal,
            double impostos,
            double frete,
            double totalFinal) {

        System.out.println("=====================================");
        System.out.println("RECIBO DE VENDA");
        System.out.println("=====================================");
        System.out.println("Data: " + new Date());
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Documento: " + documento);
        System.out.println("-------------------------------------");
        System.out.println("Subtotal Itens: R$ " + subtotal);
        System.out.println("Total Impostos: R$ " + impostos);
        System.out.println("Frete: R$ " + frete);
        System.out.println("-------------------------------------");
        System.out.println("TOTAL A PAGAR: R$ " + totalFinal);
        System.out.println("=====================================");
    }
}