package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import modelo.Financiamento;

public class App {
    public static void main(String[] args) throws Exception {
        List<Financiamento> financiamentos = new ArrayList<Financiamento>();

        financiamentos.add(new Financiamento(265000, 30, 4.21));
        financiamentos.add(new Financiamento(329500, 26, 4.88));
        financiamentos.add(new Financiamento(185000, 13, 5.21));
        financiamentos.add(new Financiamento(582386, 40, 2.03));

        Double somaValorImovel = financiamentos.stream().mapToDouble(i -> i.getValorImovel()).sum();
        Double somaTotalPagamento = financiamentos.stream().mapToDouble(i -> i.getTotalPagamento()).sum();

        // "BigDecimal" e "setScale" servem pra arredondar os doubles para 2 casas
        // decimais
        System.out.println(
                "Total de todos os imóveis: R$ " + new BigDecimal(somaValorImovel).setScale(2, RoundingMode.HALF_UP)
                        + ", total de todos os financiamentos: R$ "
                        + new BigDecimal(somaTotalPagamento).setScale(2, RoundingMode.HALF_UP) + ".");
    }
}
