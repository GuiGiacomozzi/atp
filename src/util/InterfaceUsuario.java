package util;

import java.util.Scanner;
import helpers.*;

public final class InterfaceUsuario {

    static Scanner scanner = new Scanner(System.in);

    public static double DigitarValorImovel() {
        Double valorImovel;
        do {
            System.out.println("Digite o valor do imóvel: ");
            String valorDigitado = scanner.nextLine();

            valorImovel = Double.parseDouble(valorDigitado);
        } while (!ValidarValorImovel(valorImovel));

        return valorImovel;
    }

    public static int DigitarPrazoFinanciamento() {
        Integer prazoFinanciamento;
        do {
            System.out.println("Digite o prazo do financiamento, em anos: ");
            String valorDigitado = scanner.nextLine();

            prazoFinanciamento = Integer.parseInt(valorDigitado);
        } while (!ValidarPrazoFinanciamento(prazoFinanciamento));

        return prazoFinanciamento;
    }

    public static double DigitarTaxaJuros() {
        Double taxaJuros;
        do {
            System.out.println("Digite taxa de juros: ");
            String valorDigitado = scanner.nextLine();

            taxaJuros = Double.parseDouble(valorDigitado);
        } while (!ValidarTaxaJuros(taxaJuros));

        return taxaJuros;
    }

    private static Boolean ValidarValorImovel(Double valorImovel) {
        if (!ValidacaoHelpers.validarDouble(valorImovel)) {
            System.out.println("Valor inválido!");
            return false;
        }

        if (valorImovel < 5000) {
            System.out.println("Valor do imóvel deve ser maior que R$ 5000");
            return false;
        }

        return true;
    }

    private static Boolean ValidarPrazoFinanciamento(Integer prazoFinanciamento) {
        if (!ValidacaoHelpers.validarInt(prazoFinanciamento)) {
            System.out.println("Valor inválido!");
            return false;
        }

        if (prazoFinanciamento < 2 || prazoFinanciamento > 40) {
            System.out.println("Prazo do financiamento deve ser maior que 2 anos e menor que 40 anos.");
            return false;
        }

        return true;
    }

    private static Boolean ValidarTaxaJuros(Double taxaJuros) {
        if (!ValidacaoHelpers.validarDouble(taxaJuros)) {
            System.out.println("Valor inválido!");
            return false;
        }

        if (taxaJuros > 20) {
            System.out.println("Taxa de juros deve ser menor que 20% por ano.");
            return false;
        }

        return true;
    }
}
