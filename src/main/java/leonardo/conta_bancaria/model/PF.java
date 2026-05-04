package leonardo.conta_bancaria.model;

import lombok.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PF {
    int idCliente;
    String CPF;
    String RG;
    String nome;
}
