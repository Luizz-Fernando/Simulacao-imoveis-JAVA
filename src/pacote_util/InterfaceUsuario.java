package pacote_util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {

    public Scanner scanner;
    public InterfaceUsuario(){
        this.scanner = new Scanner(System.in);
    }


    private double pedirEntradaTipoDouble(String mensagem, String tipo) {

        double valor = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print(mensagem);
                valor = scanner.nextDouble();
                if (valor <= 0) {
                    System.out.println("O valor " + tipo + " deve ser positivo");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico válido.");
                scanner.next(); // Limpar o buffer do scanner
            }
        }

        return valor;
    }

    private int pedirEntradaTipoInt(String mensagem, String tipo) {

        int valor = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print(mensagem);
                valor = scanner.nextInt();
                if (valor <= 0) {
                    System.out.println("O valor " + tipo + " deve ser positivo");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico válido.");
                scanner.next(); // Limpar o buffer do scanner
            }
        }

        return valor;
    }


    public double pedirValorImovel() {

        return pedirEntradaTipoDouble("Digite o valor do imovel -> ","do Imóvel");
    }

    public int pedirPrazoFinanciamento() {

        return pedirEntradaTipoInt("Digite o prazo de financiamento em anos -> ","do Financiamento");
    }

    public double pedirTaxaJuros() {

        double taxaJurosAnual = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {

                System.out.print("Digite a taxa de juros anual -> ");
                taxaJurosAnual = scanner.nextDouble();

                if (taxaJurosAnual <= 0) {
                    System.out.println("A taxa de juros anual deve ser positiva.");
                } else if (taxaJurosAnual >= 1000) {
                    System.out.println("A taxa de juros anual está muito alta");
                }else {
                    entradaValida = true;
                }
            }catch (InputMismatchException e){
                System.out.println("Entrada inválida. Digite um valor numérico válido.");
                scanner.next();
            }
        }

        return taxaJurosAnual;
    }

    public double pedirAreaConstruida() {

        return pedirEntradaTipoDouble("Digite a área construida -> ","da área construida");

    }

    public double pedirTamanhoTerreno() {
        return pedirEntradaTipoDouble("Digite o tamanho do terrenov-> ","do terreno");
    }

    public int pedirNumeroVagasGaragem() {
        return pedirEntradaTipoInt("Digite o núemro de vagas na garagem -> ","de vagas");
    }

    public int pedirNumeroAndar() {
        return pedirEntradaTipoInt("Digite o núemro do andar -> ","do andar");
    }

    public String pedirTipoZona() {
        while (true) {
            try {
                System.out.print("Digite o tipo de zona (ex. residencial ou comercial): ");

                return scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int pedirOpcao() {
        int opcao = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("-> ");
                opcao = scanner.nextInt();

                if (opcao < 1 || opcao > 3) {
                    System.out.println("Por favor, escolha uma opção válida (1, 2 ou 3).");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.next();
            }
        }

        return opcao;
    }


}
