public class ConversorDeMoeda {

    public double converter(double valor, double taxaOrigem, double taxaDestino) {
        return valor * (taxaDestino / taxaOrigem);
    }
}