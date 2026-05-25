package leonardo.conta_bancaria.model;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Investimentos {
    int id;
    String tipoInvestimento;
    String rendimento;

    @Override
    public String toString() {
        return id + " - " + tipoInvestimento + "\nRendimento mensal: " + rendimento;
    }
}
