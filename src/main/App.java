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

        financiamentos.add(new Casa(500000, 10, 10, 70, 100));
        financiamentos.add(new Casa(500000, 10, 10, 50, 65));
        financiamentos.add(new Apartamento(500000, 10, 10, 2, 7));
        financiamentos.add(new Terreno(500000, 10, 10, "Loja"));

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
