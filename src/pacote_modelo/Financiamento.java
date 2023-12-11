package pacote_modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinancimaneto, double taxasJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinancimaneto;
        this.taxaJurosAnual = taxasJurosAnual;
    }


    public abstract double calcularPagamentoMensal();

    public double calcularTotalPagamento(){

        return calcularPagamentoMensal() * this.prazoFinanciamento;
    }

    public double getValorImovel() {

        return this.valorImovel;
    }

    public int getPrazoFinanciamento() {

        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {

        return this.taxaJurosAnual;
    }

    public abstract String toString();


}
