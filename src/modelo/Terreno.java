package modelo;

public class Terreno extends Financiamento {
    private String tipoDeZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoDeZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);

        this.tipoDeZona = tipoDeZona;
    }

    public String getTipoDeZona() {
        return this.tipoDeZona;
    }

    public double calcularPagamentoMensal() {
        this.pagamentoMensal = super.calcularPagamentoMensal() + (super.getPagamentoMensal() * 0.02);

        return this.pagamentoMensal;
    }
}
