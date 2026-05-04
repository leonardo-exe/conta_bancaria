package leonardo.conta_bancaria.model;

import lombok.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Logradouros {
    int id;
    String logradouro;
    int idBairro;
}
