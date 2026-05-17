package leonardo.conta_bancaria.model;

import lombok.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Telefones {
    String numero;
    String ddd;
    int idCliente;
}
