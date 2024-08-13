package models;

public class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public double pagamentoMensal;
    public double totalPagamento;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double CalcularPagamentoMensal() {
        this.pagamentoMensal = (this.valorImovel / (this.prazoFinanciamento * 12) * (1 + (this.taxaJurosAnual / 12)));

        return this.pagamentoMensal;
    }

    public double CalcularTotalPagamento() {
        this.totalPagamento = this.pagamentoMensal * this.prazoFinanciamento * 12;

        return this.totalPagamento;
    }
}
