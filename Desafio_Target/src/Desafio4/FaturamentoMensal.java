//4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
//• SP – R$67.836,43
//• RJ – R$36.678,66
//• MG – R$29.229,88
//• ES – R$27.165,48
//• Outros – R$19.849,53
//
//Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.

package Desafio4;

public class FaturamentoMensal {

    public static void main(String[] args) {

        double valorSp = 67836.43;
        double valorRj = 36678.66;
        double valorMg = 29229.88;
        double valorEs = 27165.48;
        double valorOutros = 19849.53;


        double totalFaturamento = valorSp + valorRj + valorMg + valorEs + valorOutros;


        System.out.println("Valor total do faturamento: R$ " + totalFaturamento);

        System.out.printf("Percentual de representação de SP: %.2f%%\n", calcularPercentual(valorSp, totalFaturamento));
        System.out.printf("Percentual de representação de RJ: %.2f%%\n", calcularPercentual(valorRj, totalFaturamento));
        System.out.printf("Percentual de representação de MG: %.2f%%\n", calcularPercentual(valorMg, totalFaturamento));
        System.out.printf("Percentual de representação de ES: %.2f%%\n", calcularPercentual(valorEs, totalFaturamento));
        System.out.printf("Percentual de representação de Outros: %.2f%%\n", calcularPercentual(valorOutros, totalFaturamento));
    }


    private static double calcularPercentual(double valor, double total) {
        return (valor / total) * 100;
    }
}
