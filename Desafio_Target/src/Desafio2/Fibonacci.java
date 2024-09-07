//2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores
// (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci
// e retorne uma mensagem avisando se o número informado pertence ou não a sequência.

package Desafio2;

import java.util.Scanner;

public class Fibonacci {

    public static boolean VerificaFibonacci(int numero) {

        if (numero == 0 ) {
            return true;
        }

        int n1 = 0, n2 = 1;
        int numeroFibonacci = n1 + n2;


        while (numeroFibonacci < numero) {
            n1 = n2;
            n2 = numeroFibonacci;
            numeroFibonacci = n1 + n2;
        }

        return numeroFibonacci == numero;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();


        if (VerificaFibonacci(numero)) {
            System.out.println(numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(numero + " não pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }
}
