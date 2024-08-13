package models;

import java.util.Scanner;

public final class InterfaceUsuario {

    static Scanner scanner = new Scanner(System.in);

    public static double DigitarValorImovel() {
        System.out.println("Digite o valor do imóvel: ");
        String valorImovel = scanner.nextLine();

        return Double.parseDouble(valorImovel);
    }

    public static int DigitarPrazoFinanciamento() {
        System.out.println("Digite o prazo do financiamento, em anos: ");
        String prazoFinanciamento = scanner.nextLine();

        return Integer.parseInt(prazoFinanciamento);
    }

    public static double DigitarTaxaJuros() {
        System.out.println("Digite taxa de juros: ");
        String taxaJuros = scanner.nextLine();

        return Double.parseDouble(taxaJuros);
    }
}
