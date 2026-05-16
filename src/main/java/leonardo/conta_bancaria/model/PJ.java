package leonardo.conta_bancaria.model;

import lombok.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PJ {
    int idCliente;
    String cnpj;
    String razao;
}
