package modelo;

public class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;
    private double pagamentoMensal;
    private double totalPagamento;

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

    public void printInfoFinanciamento() {
        System.out.println("Dados do financiamento: " +
                "\n" + "- Pagamento mensal: R$ " + this.pagamentoMensal +
                "\n" + "- Total pagamento: R$ " + this.totalPagamento);
    }

    public double calcularPagamentoMensal() {
        this.pagamentoMensal = (this.valorImovel / (this.prazoFinanciamento * 12) * (1 + (this.taxaJurosAnual / 12)));

        return this.pagamentoMensal;
    }

    public double calcularTotalPagamento() {
        this.totalPagamento = this.pagamentoMensal * this.prazoFinanciamento * 12;

        return this.totalPagamento;
    }
}
