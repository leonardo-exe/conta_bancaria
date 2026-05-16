package leonardo.conta_bancaria.model;

import lombok.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PF {
    int idCliente;
    String cpf;
    String rg;
    String nome;
}
