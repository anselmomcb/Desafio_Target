package Desafio5;

import java.util.Scanner;


public class Invertepalavra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite uma palavra para inverter:");
        String palavra = scanner.nextLine();


        String invertida = inverterString(palavra);


        System.out.println("A sua palavra invertida fica da seguinte forma: " + invertida);


        scanner.close();
    }


    public static String inverterString(String s) {
        String resultado = "";


        for (int i = s.length() - 1; i >= 0; i--) {
            resultado += s.charAt(i);
        }

        return resultado;
    }
}

