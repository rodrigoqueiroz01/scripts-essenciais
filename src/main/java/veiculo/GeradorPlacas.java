package veiculo;

import java.util.*;

import static java.util.stream.IntStream.range;

public class GeradorPlacas {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Quantidade de placas: ");
        var quantidadePlacas = scanner.nextInt();

        var placas = gerarPlacas(quantidadePlacas);
        placas.forEach(System.out::println);

        scanner.close();
    }

    public static List<String> gerarPlacas(int quantidadePlacas) {
        List<String> placas = new ArrayList<>();
        var random = new Random();

        for (int i = 0; i < quantidadePlacas; i++) {
            var placa = new StringBuilder();
            padraoMercosulPlacas(random, placa);
            placas.add(placa.toString());
        }

        return placas;
    }

    private static void padraoMercosulPlacas(Random random, StringBuilder placa) {
        range(0, 3).forEach(i -> placa.append((char) ('A' + random.nextInt(26))));
        placa.append(random.nextInt(10));
        placa.append((char) ('A' + random.nextInt(26)));
        range(0, 2).forEach(i -> placa.append(random.nextInt(10)));
    }

}
