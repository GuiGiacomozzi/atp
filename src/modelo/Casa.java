package modelo;

public class Casa extends Financiamento {
    private int areaConstruida;
    private int tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int areaConstruida,
            int tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);

        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public double calcularPagamentoMensal() {
        this.pagamentoMensal = super.calcularPagamentoMensal() + 80;

        return this.pagamentoMensal;
    }
}
