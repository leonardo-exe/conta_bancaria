package leonardo.conta_bancaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PF {
    int id_cliente;
    String CPF;
    String RG;
    String nome;
}
