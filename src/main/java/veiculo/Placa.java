package veiculo;

import lombok.*;

import java.util.*;

import static java.util.stream.IntStream.range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Placa {

    private List<String> placas = new ArrayList<>();
    private StringBuilder placa = new StringBuilder();
    private Random random = new Random();

    public List<String> gerarPlacas(int quantidadePlacas) {
        for (int i = 0; i < quantidadePlacas; i++) {
            padraoMercosulPlacas(getRandom(), getPlaca());
            getPlacas().add(getPlaca().toString());
        }

        return getPlacas();
    }

    public void padraoMercosulPlacas(Random random, StringBuilder placa) {
        range(0, 3).forEach(i -> placa.append((char) ('A' + random.nextInt(26))));
        placa.append(random.nextInt(10));
        placa.append((char) ('A' + random.nextInt(26)));
        range(0, 2).forEach(i -> placa.append(random.nextInt(10)));
    }

}
