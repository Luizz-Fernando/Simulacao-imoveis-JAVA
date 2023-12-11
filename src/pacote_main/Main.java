package pacote_main;

import pacote_modelo.Apartamento;
import pacote_modelo.Casa;
import pacote_modelo.Financiamento;
import pacote_modelo.Terreno;
import pacote_util.InterfaceUsuario;
import pacote_util.GerenciadorArquivoTxt;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println();

        ArrayList<Financiamento> listaDeFinanciamentos = new ArrayList<>();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        double totalValorImoveis = 0;
        double totalFinanciamentos = 0;

        System.out.println("********* SISTEMA DE SIMULAÇÃO DE IMOVEIS *********\n");

        System.out.println("Digite os valores para um financiamento: \n");

        double valorImovel     = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJuros       = interfaceUsuario.pedirTaxaJuros();

        System.out.println("\nEscolha o tipo do financiamento:\n (1) - Casa\n (2) - Aparteamento\n (3) - Terreno \n");

        int opcao = interfaceUsuario.pedirOpcao();

        System.out.println("\nPara esse financiamento é necessário mais algumas informações\n");

        switch (opcao) {
            case 1:

                double areaConstruida = interfaceUsuario.pedirAreaConstruida();
                double tamanhoTerreno = interfaceUsuario.pedirTamanhoTerreno();
                Casa casaUsuario = new Casa(valorImovel,prazoFinanciamento,taxaJuros,areaConstruida,tamanhoTerreno);
                listaDeFinanciamentos.add(casaUsuario);
                totalValorImoveis += casaUsuario.getValorImovel();
                totalFinanciamentos += casaUsuario.calcularTotalPagamento();

                break;
            case 2:

                int vagasGaragem = interfaceUsuario.pedirNumeroVagasGaragem();
                int numeroAndar = interfaceUsuario.pedirNumeroAndar();
                Apartamento apartamentoUsuario = new Apartamento(valorImovel,prazoFinanciamento,taxaJuros,vagasGaragem,numeroAndar);
                listaDeFinanciamentos.add(apartamentoUsuario);
                totalValorImoveis += apartamentoUsuario.getValorImovel();
                totalFinanciamentos += apartamentoUsuario.calcularTotalPagamento();

                break;
            case 3:

                String tipoZona = interfaceUsuario.pedirTipoZona();
                Terreno terrenoUsuario = new Terreno(valorImovel,prazoFinanciamento,taxaJuros,tipoZona);
                listaDeFinanciamentos.add(terrenoUsuario);
                totalValorImoveis += terrenoUsuario.getValorImovel();
                totalFinanciamentos += terrenoUsuario.calcularTotalPagamento();

                break;
            default:
                System.out.println("Opção inválida");
                break;
        }


        // CASA
        Casa casa1 = new Casa(70000,7,10,50,100);
        listaDeFinanciamentos.add(casa1);
        totalValorImoveis += casa1.getValorImovel();
        totalFinanciamentos += casa1.calcularTotalPagamento();

        Casa casa2 = new Casa(80000,10,5,25,50);
        listaDeFinanciamentos.add(casa2);
        totalValorImoveis += casa2.getValorImovel();
        totalFinanciamentos += casa2.calcularTotalPagamento();

        System.out.println();

        // APARTAMENTO
        Apartamento apartamento1 = new Apartamento(90000,11,10,4,8);
        listaDeFinanciamentos.add(apartamento1);
        totalValorImoveis += apartamento1.getValorImovel();
        totalFinanciamentos += apartamento1.calcularTotalPagamento();

        Apartamento apartamento2 = new Apartamento(50000,10,5,2,6);
        listaDeFinanciamentos.add(apartamento2);
        totalValorImoveis += apartamento2.getValorImovel();
        totalFinanciamentos += apartamento2.calcularTotalPagamento();

        System.out.println();

        // TERRENO
        Terreno terreno = new Terreno(150000,3,5,"Comercial");
        listaDeFinanciamentos.add(terreno);
        totalValorImoveis += terreno.getValorImovel();
        totalFinanciamentos += terreno.calcularTotalPagamento();

        System.out.println();

        // MOSTRANDO INFORMAÇÕES
        for (int i = 0; i < listaDeFinanciamentos.size(); i++) {

            if (i == 0){
                System.out.println("FINANCIAMENTO ESCOLHIDO:");
            }

            if (i == 1){
                System.out.println("OUTROS FINANCIAMENTOS:");
            }


            Financiamento financiamento = listaDeFinanciamentos.get(i);

            System.out.println(financiamento);

            System.out.println();

        }

        System.out.format("Total de todos os imóveis: R$ %.2f%n", totalValorImoveis);
        System.out.format("Total de todos os financiamentos: R$ %.2f%n", totalFinanciamentos);

        System.out.println();

        //-------------------------------------------------------------------------------------------------

        // Salvando os dados do financiamento em um arquivo .txt

        ArrayList<String> dadosFinanciamentos = new ArrayList<>();

        for (Financiamento financiamento : listaDeFinanciamentos) {
            dadosFinanciamentos.add(financiamento.toString());
        }

        GerenciadorArquivoTxt gerenciadorArquivoTxt = new GerenciadorArquivoTxt();

        gerenciadorArquivoTxt.salvarFinanciamentos(dadosFinanciamentos, "dados_financiamentos.txt");



    }

}