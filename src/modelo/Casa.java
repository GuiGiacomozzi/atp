package modelo;

import helpers.ArquivoHelpers;
import util.AcrescimoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    private int areaConstruida;
    private int tamanhoTerreno;
    private Double valorAcrescimo;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int areaConstruida,
            int tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public int getAreaConstruida() {
        return this.areaConstruida;
    }

    public int getTamanhoTerreno() {
        return this.tamanhoTerreno;
    }

    public double calcularPagamentoMensal() {
        valorAcrescimo = 80d;
        var valorJuros = this.pagamentoMensal - super.calcularPagamentoMensal();
        try {
            this.pagamentoMensal = super.calcularPagamentoMensal() + valorAcrescimo;
            this.validarValorAcrescimo(valorJuros, valorAcrescimo);
        } catch (AcrescimoMaiorDoQueJurosException ex) {
            this.valorAcrescimo = valorJuros;
        }

        return this.pagamentoMensal;
    }

    public String toString() {
        var sb = new StringBuilder();

        sb.append("Dados do financiamento de Casa: ");
        ArquivoHelpers.adicionarQuebraDeLinha(sb);
        sb.append(super.toString());
        ArquivoHelpers.adicionarQuebraDeLinha(sb);
        sb.append("- Area construida: " + getAreaConstruida() + "m2");
        ArquivoHelpers.adicionarQuebraDeLinha(sb);
        sb.append("- Tamanho do terreno: " + getTamanhoTerreno() + "m2");

        return sb.toString();
    }

    private void validarValorAcrescimo(Double valorJuros, Double valorAcrescimo)
            throws AcrescimoMaiorDoQueJurosException {
        if (valorJuros < valorAcrescimo) {
            throw new AcrescimoMaiorDoQueJurosException(
                    "Valor do juros não pode ser maior do que o valor do acréscimo!");
        }
    }
}
