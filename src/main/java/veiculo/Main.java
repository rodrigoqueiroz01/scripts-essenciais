package veiculo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var placa = new Placa();
        placa.gerarPlacas(0).forEach(System.out::println);

    }

}
