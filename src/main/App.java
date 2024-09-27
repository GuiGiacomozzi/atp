package main;

import java.util.ArrayList;
import java.util.List;
import helpers.ArquivoHelpers;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;

public class App {
    public static void main(String[] args) throws Exception {
        List<Financiamento> financiamentos = new ArrayList<Financiamento>();

        financiamentos.add(new Casa(600000, 30, 5, 70, 100));
        financiamentos.add(new Casa(3500000, 39, 3.25, 50, 65));
        financiamentos.add(new Apartamento(263000, 25, 8, 2, 7));
        financiamentos.add(new Terreno(5500000, 30, 2.87, "Loja"));

        var sb = new StringBuilder();

        for (int i = 0; i < financiamentos.size(); i++) {
            sb.append(financiamentos.get(i).toString());
            ArquivoHelpers.adicionarQuebraDeLinha(sb);
            ArquivoHelpers.adicionarQuebraDeLinha(sb);
        }

        String nomeDoArquivo = "dadosFinanciamento.txt";
        String nomeDoArquivoObjeto = "dadosFinanciamento-objeto.txt";

        ArquivoHelpers.SalvarArquivo(sb.toString(), nomeDoArquivo);

        var dadosFinanciamento = ArquivoHelpers.AbrirArquivoComoString(nomeDoArquivo);

        System.out.println("------------ Dados lidos de arquivo como string ------------");
        System.out.println(dadosFinanciamento);

        ArquivoHelpers.SalvarArquivoComoObjeto(financiamentos, nomeDoArquivoObjeto);

        var financiamentosArquivo = ArquivoHelpers.LerArquivoComoListaObjetoFinanciamento(nomeDoArquivoObjeto);

        System.out.println("------------ Dados lidos de arquivo como object ------------");
        for (int i = 0; i < financiamentosArquivo.size(); i++) {
            System.out.println(financiamentosArquivo.get(i).toString() + "\n");
        }
    }
}
