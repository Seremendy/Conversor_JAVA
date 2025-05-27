public class Formatador {

    public static double arredondar(double valor, int casasDecimais) {
        double fator = Math.pow(10, casasDecimais);
        return Math.round(valor * fator) / fator;
    }
}