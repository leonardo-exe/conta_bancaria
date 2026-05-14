package leonardo.conta_bancaria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoCompleto {
    String cep;
    String logradouro;
    String bairro;
    String localidade;
    String estado;
}
