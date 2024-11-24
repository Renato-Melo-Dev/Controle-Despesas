package Utils;

import java.util.Scanner;

public class InputUtils {

    public static double obterValor(Scanner scanner) {
        double valor;
        while (true) {
            try {
                System.out.print("Digite o valor: ");
                valor = Double.parseDouble(scanner.nextLine());
                if (valor <= 0) {
                    System.out.println("O valor deve ser maior que zero.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido.");
            }
        }
        return valor;
    }
}
