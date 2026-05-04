package leonardo.conta_bancaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Agencias {
    int id;
    String numero_agencia;
    int id_endereco;
    int id_banco;
}
