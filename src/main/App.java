package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;

public class App {
    public static void main(String[] args) throws Exception {
        List<Financiamento> financiamentos = new ArrayList<Financiamento>();

        financiamentos.add(new Casa(500000, 10, 10, 70, 100));
        financiamentos.add(new Casa(500000, 10, 10, 50, 65));
        financiamentos.add(new Apartamento(500000, 10, 10, 2, 7));
        financiamentos.add(new Terreno(500000, 10, 10, "Loja"));

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
