package veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GerarInsertsVeiculos {

    private static final String[] BRANDS = {"VOLKSWAGEN", "TOYOTA", "FORD", "CHEVROLET", "HONDA"};
    private static final String[] COLORS = {"BRANCO", "PRETO", "VERMELHO", "AZUL", "PRATA"};
    private static final String[] MODELS = {"FOX", "COROLLA", "FIESTA", "ONIX", "CIVIC"};
    private static final String[] TYPES = {"PARTICULAR", "COMERCIAL"};

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Quantidade de veículos: ");
        var quantidadeVeiculos = scanner.nextInt();

        var inserts = gerarInsertsVeiculos(quantidadeVeiculos);
        inserts.forEach(System.out::println);

        scanner.close();
    }

    private static List<String> gerarInsertsVeiculos(int quantidade) {
        List<String> inserts = new ArrayList<>();
        List<String> placas = GeradorPlacas.gerarPlacas(quantidade);
        var random = new Random();

        for (int indice = 0; indice < quantidade; indice++) {
            var insert = insertVeiculos(random, placas, indice);
            inserts.add(insert);
        }

        return inserts;
    }

    private static String insertVeiculos(Random random, List<String> placas, int indice) {
        return String.format(
                """
                INSERT INTO public.vehicle (brand, color, model, plate, monitored, type, registration_date)
                VALUES ('%s', '%s', '%s', '%s', true, '%s', now());
                """,
                BRANDS[random.nextInt(BRANDS.length)],
                COLORS[random.nextInt(COLORS.length)],
                MODELS[random.nextInt(MODELS.length)],
                placas.get(indice),
                TYPES[random.nextInt(TYPES.length)]
        );
    }
}
