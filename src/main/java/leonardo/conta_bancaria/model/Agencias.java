package leonardo.conta_bancaria.model;

import lombok.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Agencias {
    int id;
    String numeroAgencia;
    int idEndereco;
    int idBanco;
}
