package modelo;

import java.io.Serializable;
import helpers.ArquivoHelpers;

public abstract class Financiamento implements Serializable {
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;
    protected double pagamentoMensal;
    protected double totalPagamento;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;

        calcularPagamentoMensal();
        calcularTotalPagamento();
    }

    // #region Getters

    public double getValorImovel() {
        return this.valorImovel;
    }

    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    public double getPagamentoMensal() {
        return this.pagamentoMensal;
    }

    public double getTotalPagamento() {
        return this.totalPagamento;
    }

    // #endregion

    public String toString() {
        var sb = new StringBuilder();

        sb.append("- Valor imovel: R$ " + getValorImovel());
        ArquivoHelpers.adicionarQuebraDeLinha(sb);
        sb.append("- Prazo de financiamento: " + getPrazoFinanciamento() + " ano(s)");
        ArquivoHelpers.adicionarQuebraDeLinha(sb);
        sb.append("- Taxa de juros anual: " + getTaxaJurosAnual() + "%");
        ArquivoHelpers.adicionarQuebraDeLinha(sb);
        sb.append("- Pagamento mensal: R$ " + getPagamentoMensal());
        ArquivoHelpers.adicionarQuebraDeLinha(sb);
        sb.append("- Total pagamento: R$ " + getTotalPagamento());

        return sb.toString();
    }

    public double calcularPagamentoMensal() {
        this.pagamentoMensal = (this.valorImovel / (this.prazoFinanciamento * 12)
                * (1 + ((this.taxaJurosAnual / 100) / 12)));

        return this.pagamentoMensal;
    }

    public double calcularTotalPagamento() {
        this.totalPagamento = this.pagamentoMensal * this.prazoFinanciamento * 12;

        return this.totalPagamento;
    }
}
