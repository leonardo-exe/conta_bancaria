package leonardo.conta_bancaria.model;

import lombok.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Enderecos {
    int id;
    String CEP;
    int numero;
    String complemento;
}
