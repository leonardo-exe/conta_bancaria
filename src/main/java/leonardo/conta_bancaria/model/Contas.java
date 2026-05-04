package leonardo.conta_bancaria.model;

import lombok.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Contas {
    int id;
    String numeroConta;
    int idCliente;
    int idAgencia;
    String dataAbertura;
}
