package modelo;

public class Terreno extends Financiamento {

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);

        pagamentoMensal += (pagamentoMensal * 0.02);
    }

    public double calcularPagamentoMensal() {
        this.pagamentoMensal = super.calcularPagamentoMensal() + (super.getPagamentoMensal() * 0.02);

        return this.pagamentoMensal;
    }
}
