import models.Financiamento;
import models.InterfaceUsuario;

public class App {
    public static void main(String[] args) throws Exception {
        double valorImovel = InterfaceUsuario.DigitarValorImovel();
        int prazoFinanciamento = InterfaceUsuario.DigitarPrazoFinanciamento();
        double taxaJuros = InterfaceUsuario.DigitarTaxaJuros();

        var financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJuros);

        System.out.println(
                "Criado financiamento com valor de " + valorImovel + ", financiado em " + prazoFinanciamento
                        + "ano(s) e com taxa de juros de " + taxaJuros + ".");
    }
}
