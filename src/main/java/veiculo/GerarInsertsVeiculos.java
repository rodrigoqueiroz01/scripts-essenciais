package veiculo;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class GerarInsertsVeiculos {

    private static final String[] BRANDS = {"VOLKSWAGEN", "TOYOTA", "FORD", "CHEVROLET", "HONDA"};
    private static final String[] COLORS = {"BRANCO", "PRETO", "VERMELHO", "AZUL", "PRATA"};
    private static final String[] MODELS = {"FOX", "COROLLA", "FIESTA", "ONIX", "CIVIC"};
    private static final String[] TYPES = {"PARTICULAR", "COMERCIAL"};

    // TODO refatorar para Veiculo e instanciar na classe Main

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Quantidade de veículos: ");
        var quantidadeVeiculos = scanner.nextInt();

        var inserts = gerarInsertsVeiculos(quantidadeVeiculos);
        inserts.forEach(System.out::println);

        scanner.close();
    }

    private static List<String> gerarInsertsVeiculos(int quantidade) {
        return range(0, quantidade)
                .mapToObj(indice -> insertVeiculos(indice, quantidade))
                .collect(toList());
    }

    private static String insertVeiculos(int indice, int quantidade) {
        var random = new Random();
        var placa = new Placa();
        var placas = placa.gerarPlacas(quantidade);

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
