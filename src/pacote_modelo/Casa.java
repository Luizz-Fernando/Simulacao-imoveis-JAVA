package pacote_modelo;

public class Casa extends Financiamento{

    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinancimaneto, double taxasJurosAnual, double areaConstruida, double tamanhoTerreno){
        super(valorImovel,prazoFinancimaneto,taxasJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {

        double taxaMensal      = getTaxaJurosAnual() / 12;
        int meses              = getPrazoFinanciamento() * 12;
        double pagamentoMensal = (getValorImovel() * (1 + taxaMensal) / meses);

        return pagamentoMensal + 80;
    }

    @Override
    public String toString(){
        String informacoes =

                ">>>>>>>>>> Casa <<<<<<<<<\n" +

                "Valor do Imóvel: R$ %.2f\n" +
                "Prazo do Financiamento: %d anos\n" +
                "Taxa de Juros Anual: %.2f%%\n" +
                "Área Construída: %.2fm²\n" +
                "Tamanho do Terreno: %.2fm²\n" +
                "-------------------------------\n"+
                "Total do Pagamento: R$ %.2f";

        return String.format(informacoes, getValorImovel(), getPrazoFinanciamento(), getTaxaJurosAnual(), this.areaConstruida, this.tamanhoTerreno, calcularTotalPagamento());
    }
}
