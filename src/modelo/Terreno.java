package modelo;

import helpers.ArquivoHelpers;

public class Terreno extends Financiamento {
    private String tipoDeZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoDeZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);

        this.tipoDeZona = tipoDeZona;
    }

    public String getTipoDeZona() {
        return this.tipoDeZona;
    }

    public String toString() {
        var sb = new StringBuilder();

        sb.append("Dados do financiamento de Terreno: ");
        ArquivoHelpers.adicionarQuebraDeLinha(sb);
        sb.append(super.toString());
        ArquivoHelpers.adicionarQuebraDeLinha(sb);
        sb.append("- Tipo de zona: " + getTipoDeZona());

        return sb.toString();
    }

    public double calcularPagamentoMensal() {
        this.pagamentoMensal = super.calcularPagamentoMensal() + (super.getPagamentoMensal() * 0.02);

        return this.pagamentoMensal;
    }
}
