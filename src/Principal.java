import java.util.Map;
import java.util.Scanner;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        ServicoMoeda servico = new ServicoMoeda(); // cria o serviço
        TaxasDeCambio taxas = null;

        try {
            taxas = servico.obterTaxas("USD"); // você pode mudar a base se quiser
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao conectar com a API: " + e.getMessage());
            return;
        }

        Map<String, Double> taxasDeConversao = taxas.getConversion_rates();


        String[] moedas = { "BRL", "USD", "EUR", "ARS", "CLP", "COP" };
        Map<String, String> nomesMoedas = Map.of(
                "BRL", "Real",
                "USD", "Dólar",
                "EUR", "Euro",
                "ARS", "Peso Argentino",
                "CLP", "Peso Chileno",
                "COP", "Peso Colombiano"
        );

        System.out.println("\n=== Conversor de Moedas ===");
        for (int i = 0; i < moedas.length; i++) {
            System.out.println((i + 1) + " - " + nomesMoedas.get(moedas[i]) + " (" + moedas[i] + ")");
        }
        System.out.println("0 - Sair");
        System.out.print("Escolha a moeda de origem: ");
        int moedaEscolhida = leitura.nextInt();

        if (moedaEscolhida == 0) {
            System.out.println("Saindo...");
            return;
        }

        if (moedaEscolhida < 1 || moedaEscolhida > moedas.length) {
            System.out.println("Opção inválida.");
            return;
        }

        String moedaOrigem = moedas[moedaEscolhida - 1];

        System.out.println("\nEscolha a moeda de destino:");
        for (int i = 0; i < moedas.length; i++) {
            if (!moedas[i].equals(moedaOrigem)) {
                System.out.println((i + 1) + " - " + nomesMoedas.get(moedas[i]) + " (" + moedas[i] + ")");
            }
        }
        System.out.print("Escolha: ");
        int destinoEscolhido = leitura.nextInt();

        if (destinoEscolhido < 1 || destinoEscolhido > moedas.length || destinoEscolhido == moedaEscolhida) {
            System.out.println("Opção inválida.");
            return;
        }

        String moedaDestino = moedas[destinoEscolhido - 1];

        System.out.print("Digite o valor em " + nomesMoedas.get(moedaOrigem) + " (" + moedaOrigem + "): ");
        double valor = leitura.nextDouble();

        double taxaOrigem = taxasDeConversao.get(moedaOrigem);
        double taxaDestino = taxasDeConversao.get(moedaDestino);

        double valorConvertido = valor * (taxaDestino / taxaOrigem);


        System.out.println("Resultado: "
                + Formatador.arredondar(valor, 2) + " " + nomesMoedas.get(moedaOrigem) + " (" + moedaOrigem + ") = "
                + Formatador.arredondar(valorConvertido, 2) + " " + nomesMoedas.get(moedaDestino) + " (" + moedaDestino + ")");




        leitura.close();
    }
}