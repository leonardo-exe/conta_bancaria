package leonardo.conta_bancaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoAgencias {
    String numeroAgencia;
    int id_banco;
    int id;
    int numero;
    String logradouro;
    String bairro;
    String cidade;
    String sigla;

    @Override
    public String toString() {
        return "Agencia: " + numeroAgencia + " - " + logradouro + ", " + numero + ", " + bairro + ", " + cidade + ", " + sigla;
    }
}
