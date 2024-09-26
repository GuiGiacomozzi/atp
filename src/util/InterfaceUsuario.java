package util;

import java.util.Scanner;
import helpers.*;

public final class InterfaceUsuario {

    static Scanner scanner = new Scanner(System.in);

    public static double DigitarValorImovel() {
        Double valorImovel = 0d;
        try {
            do {
                System.out.println("Digite o valor do imóvel: ");
                String valorDigitado = scanner.nextLine();

                valorImovel = Double.parseDouble(valorDigitado);
            } while (!ValidarValorImovel(valorImovel));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            DigitarValorImovel();
        }

        return valorImovel;
    }

    public static int DigitarPrazoFinanciamento() {
        Integer prazoFinanciamento = 0;
        try {
            do {
                System.out.println("Digite o prazo do financiamento, em anos: ");
                String valorDigitado = scanner.nextLine();

                prazoFinanciamento = Integer.parseInt(valorDigitado);
            } while (!ValidarPrazoFinanciamento(prazoFinanciamento));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            DigitarPrazoFinanciamento();
        }

        return prazoFinanciamento;
    }

    public static double DigitarTaxaJuros() {
        Double taxaJuros = 0d;
        try {
            do {
                System.out.println("Digite taxa de juros: ");
                String valorDigitado = scanner.nextLine();

                taxaJuros = Double.parseDouble(valorDigitado);
            } while (!ValidarTaxaJuros(taxaJuros));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            DigitarTaxaJuros();
        }

        return taxaJuros;
    }

    private static Boolean ValidarValorImovel(Double valorImovel) throws Exception {
        if (!ValidacaoHelpers.validarDouble(valorImovel)) {
            throw new ParametroInvalidoException("Valor de entrada inválido para valor do imóvel, tente novamente");
        }

        if (valorImovel < 5000) {
            throw new ValorImovelInvalidoException("Valor do imóvel deve ser maior que R$ 5000");
        }

        return true;
    }

    private static Boolean ValidarPrazoFinanciamento(Integer prazoFinanciamento) throws Exception {
        if (!ValidacaoHelpers.validarInt(prazoFinanciamento)) {
            throw new ParametroInvalidoException(
                    "Valor de entrada para prazo de financiamento inválido, tente novamente");
        }

        if (prazoFinanciamento < 2 || prazoFinanciamento > 40) {
            throw new PrazoFinanciamentoInvalidoException(
                    "Prazo do financiamento deve ser maior que 2 anos e menor que 40 anos.");
        }

        return true;
    }

    private static Boolean ValidarTaxaJuros(Double taxaJuros) throws Exception {
        if (!ValidacaoHelpers.validarDouble(taxaJuros)) {
            throw new ParametroInvalidoException("Valor de entrada para taxa de juros inválido, tente novamente");
        }

        if (taxaJuros > 20) {
            throw new TaxaJurosInvalidoException("Taxa de juros deve ser menor que 20% por ano.");
        }

        return true;
    }
}
