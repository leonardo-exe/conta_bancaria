package leonardo.conta_bancaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Contas {
    int id;
    String numero_conta;
    int id_cliente;
    int id_agencia;
    String data_abertura;
}
