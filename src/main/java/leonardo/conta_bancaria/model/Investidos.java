package leonardo.conta_bancaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Investidos {
    int id_conta;
    int id_investimento;
    BigDecimal valor;
    String data_investimento;
}
