package modelo;

public class Casa extends Financiamento {

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    public double calcularPagamentoMensal() {
        this.pagamentoMensal = super.calcularPagamentoMensal() + 80;

        return this.pagamentoMensal;
    }
}
