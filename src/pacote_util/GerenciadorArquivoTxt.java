package pacote_util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GerenciadorArquivoTxt {

    public void salvarFinanciamentos(List<String> dadosFinanciamentos, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (String dados : dadosFinanciamentos) {
                writer.write(dados);
                writer.newLine();
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Ou faça algum tratamento de exceção apropriado
        }
    }
}
