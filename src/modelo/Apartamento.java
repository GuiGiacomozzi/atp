package modelo;

public class Apartamento extends Financiamento {
    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem,
            int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);

        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    public int getVagasGaragem() {
        return this.vagasGaragem;
    }

    public int getNumeroAndar() {
        return this.numeroAndar;
    }

    public double calcularPagamentoMensal() {
        double taxaJurosMensal = (this.taxaJurosAnual / 100) / 12;

        int mesesFinanciamento = this.prazoFinanciamento * 12;

        var taxaJurosMensalCalculo = 1 + taxaJurosMensal;

        pagamentoMensal = (this.valorImovel * Math.pow(taxaJurosMensalCalculo, mesesFinanciamento))
                / (Math.pow(taxaJurosMensalCalculo, (mesesFinanciamento - 1)));

        return pagamentoMensal;
    }
}
