package leonardo.conta_bancaria.model;

import lombok.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Bairros {
    int id;
    String bairro;
    int idCidade;
}
