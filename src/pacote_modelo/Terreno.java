package pacote_modelo;

public class Terreno extends Financiamento{

    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {

        double taxaMensal = getTaxaJurosAnual() / 12;
        int meses         = getPrazoFinanciamento() * 12;

        return (getValorImovel() * (1 + taxaMensal) / meses) * 1.02;
    }

    @Override
    public String toString() {
        String informacoes =

                ">>>>>>>>>> Terreno <<<<<<<<<<\n" +

                "Valor do Imóvel: R$ %.2f\n" +
                "Prazo do Financiamento: %d anos\n" +
                "Taxa de Juros Anual: %.2f%%\n" +
                "Tipo de Zona: %s\n" +
                "-------------------------------\n"+
                "Total do Pagamento: R$ %.2f";

        return String.format(informacoes, getValorImovel(), getPrazoFinanciamento(), getTaxaJurosAnual(), this.tipoZona, calcularTotalPagamento());
    }
}
