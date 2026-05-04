package leonardo.conta_bancaria.model;

import lombok.*;

import java.math.BigDecimal;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Investimentos {
    int id;
    String tipoInvestimento;
    BigDecimal rendimento;
}
