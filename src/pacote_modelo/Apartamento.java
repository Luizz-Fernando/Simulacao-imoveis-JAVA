package pacote_modelo;

public class Apartamento extends Financiamento{

    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar  = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {

        double taxaMensal = (this.getTaxaJurosAnual() / 12)/100;
        int meses = this.getPrazoFinanciamento() * 12;

        return ((getValorImovel() * taxaMensal) * (Math.pow((1 + taxaMensal) , (meses)))) /
                (Math.pow((1 + taxaMensal), meses) - 1);
    }

    @Override
    public String toString(){
        String informacoes =

                ">>>>>>>>>> Apartamento <<<<<<<<<<\n" +

                "Valor do Imóvel: R$ %.2f\n" +
                "Prazo do Financiamento: %d anos\n" +
                "Taxa de Juros Anual: %.2f%%\n" +
                "Número de Vagas na Garagem: %d\n" +
                "Número do Andar: %d\n" +
                "-------------------------------\n"+
                "Total do Pagamento: R$ %.2f";

        return String.format(informacoes, getValorImovel(), getPrazoFinanciamento(), getTaxaJurosAnual(), this.vagasGaragem, this.numeroAndar, calcularTotalPagamento());
    }
}
