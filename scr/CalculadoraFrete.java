public class CalculadoraFrete {

    private static final int CLIENTE_VIP = 1;
    private static final int CLIENTE_COMUM = 2;
    private static final double FRETE_REGIONAL = 15.0;
    private static final double FRETE_NACIONAL = 50.0;

    public double calcular(int tipoCliente, String endereco) {
        if (tipoCliente == CLIENTE_VIP) {
            return 0;
        }

        if (tipoCliente == CLIENTE_COMUM) {
            if (endereco.contains("SP")
                    || endereco.contains("RJ")
                    || endereco.contains("MG")) {
                return FRETE_REGIONAL;
            }
        }

        return FRETE_NACIONAL;
    }
}