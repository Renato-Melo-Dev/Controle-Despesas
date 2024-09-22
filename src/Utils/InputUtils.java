package Utils;

import java.util.Scanner;

public class InputUtils {
    public static double obterValor(Scanner scanner) {
        double valor = 0;
        boolean valorValido = false;
        while (!valorValido) {
            try {
                System.out.print("Digite o valor: ");
                valor = scanner.nextDouble();
                scanner.nextLine(); // Limpa o buffer
                valorValido = true;
            } catch (Exception e) {
                System.out.println("Valor inválido. Por favor, digite um número válido.");
                scanner.nextLine(); // Limpa o buffer em caso de erro
            }
        }
        return valor;
    }
}
