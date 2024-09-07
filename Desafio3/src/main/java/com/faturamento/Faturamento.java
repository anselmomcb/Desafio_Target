//3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar,
// que calcule e retorne:
//• O menor valor de faturamento ocorrido em um dia do mês;
//• O maior valor de faturamento ocorrido em um dia do mês;
//• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
//
//IMPORTANTE:
//a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
//b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Faturamento {

    public static void main(String[] args) {
        // Caminho do arquivo JSON
        String filePath = "C:\\Users\\Anselmo\\Desktop\\Desafio_Target\\Desafio3\\src\\main\\resources\\dados.json";

        try {
            // Ler o arquivo JSON do caminho especificado
            String json = new String(Files.readAllBytes(new File(filePath).toPath()));

            // Converter para JSONArray
            JSONArray faturamentos = new JSONArray(json);

            // Listas para armazenar valores de faturamento
            List<Double> valores = new ArrayList<>();
            double totalFaturamento = 0.0;

            // Processar cada objeto JSON
            for (int i = 0; i < faturamentos.length(); i++) {
                JSONObject item = faturamentos.getJSONObject(i);
                double valor = item.getDouble("valor");
                if (valor > 0) { // Ignora dias sem faturamento
                    valores.add(valor);
                    totalFaturamento += valor;
                }
            }

            // Verificar se há valores para evitar divisão por zero
            if (valores.isEmpty()) {
                System.out.println("Não há dados de faturamento para processar.");
                return;
            }

            // Cálculo do menor e maior valor
            double menorFaturamento = valores.get(0);
            double maiorFaturamento = valores.get(0);

            for (double valor : valores) {
                if (valor < menorFaturamento) {
                    menorFaturamento = valor;
                }
                if (valor > maiorFaturamento) {
                    maiorFaturamento = valor;
                }
            }

            // Cálculo da média mensal
            double mediaMensal = totalFaturamento / valores.size();

            // Contar dias com faturamento superior à média mensal
            int diasAcimaMedia = 0;
            for (double valor : valores) {
                if (valor > mediaMensal) {
                    diasAcimaMedia++;
                }
            }

            // Resultados
            System.out.println("Menor valor de faturamento: " + menorFaturamento);
            System.out.println("Maior valor de faturamento: " + maiorFaturamento);
            System.out.println("Número de dias com faturamento superior à média mensal: " + diasAcimaMedia);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro ao processar o JSON: " + e.getMessage());
        }
    }
}
