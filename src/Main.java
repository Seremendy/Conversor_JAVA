import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoeda conversor = new ConversorDeMoeda();

        while (true) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1 - Real → Dólar");
            System.out.println("2 - Dólar → Real");
            System.out.println("3 - Real → Euro");
            System.out.println("4 - Euro → Dólar");
            System.out.println("==========================");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Digite um número válido.");
                scanner.nextLine();
                continue;
            }

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }

            Map<Integer, String[]> opcoes = Map.of(
                    1, new String[] {"BRL", "USD"},
                    2, new String[] {"USD", "BRL"},
                    3, new String[] {"BRL", "EUR"},
                    4, new String[] {"EUR", "USD"}
            );

            if (!opcoes.containsKey(opcao)) {
                System.out.println("Opção inválida.");
                continue;
            }

            String[] moedas = opcoes.get(opcao);
            String from = moedas[0];
            String to = moedas[1];

            System.out.print("Digite o valor a converter: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Valor inválido.");
                scanner.nextLine();
                continue;
            }

            double amount = scanner.nextDouble();
            if (amount <= 0) {
                System.out.println("Valor precisa ser maior que 0.");
                continue;
            }

            double resultado = conversor.converter(from, to, amount);
            double arredondado = Math.round(resultado * 100.0) / 100.0;

            System.out.println(amount + " " + from + " = " + arredondado + " " + to);
        }

        scanner.close();
    }
}
