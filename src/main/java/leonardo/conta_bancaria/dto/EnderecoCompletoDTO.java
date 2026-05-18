package leonardo.conta_bancaria.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoCompletoDTO {
    String cep;
    String logradouro;
    String bairro;
    String localidade;
    String estado;
}
