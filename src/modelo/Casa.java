package modelo;

import util.AcrescimoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    private int areaConstruida;
    private int tamanhoTerreno;

    private Double valorAcrescimo;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int areaConstruida,
            int tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);

        this.valorAcrescimo = 80d;
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
        var valorJuros = this.pagamentoMensal - super.calcularPagamentoMensal();
        try {
            this.pagamentoMensal = super.calcularPagamentoMensal() + valorAcrescimo;
            this.validarValorAcrescimo(valorJuros, valorAcrescimo);
        } catch (AcrescimoMaiorDoQueJurosException ex) {
            this.valorAcrescimo = valorJuros;
        }
        return this.pagamentoMensal;
    }

    private void validarValorAcrescimo(Double valorJuros, Double valorAcrescimo)
            throws AcrescimoMaiorDoQueJurosException {
        if (valorJuros < valorAcrescimo) {
            throw new AcrescimoMaiorDoQueJurosException(
                    "Valor do juros não pode ser maior do que o valor do acréscimo!");
        }
    }
}
