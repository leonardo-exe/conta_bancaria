package leonardo.conta_bancaria.model;

import lombok.*;

import java.math.BigDecimal;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Investidos {
    int idConta;
    int idInvestimento;
    BigDecimal valor;
    String dataInvestimento;
}
