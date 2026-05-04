package leonardo.conta_bancaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Enderecos {
    int id;
    String CEP;
    int numero;
    String complemento;
}
