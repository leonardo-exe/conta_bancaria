package leonardo.conta_bancaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewEnderecos {
    int id;
    int numero;
    String logradouro;
    String bairro;
    String cidade;
    String sigla;
}
