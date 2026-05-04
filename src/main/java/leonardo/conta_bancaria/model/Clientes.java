package leonardo.conta_bancaria.model;

import lombok.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Clientes {
    int id;
    int idEndereco;
    String tipoPessoa;
}
