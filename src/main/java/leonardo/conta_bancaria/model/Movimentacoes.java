package leonardo.conta_bancaria.model;

import lombok.*;

import java.math.BigDecimal;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Movimentacoes {
    int idConta1;
    int idConta2;
    int idTransacao;
    BigDecimal valor;
    String dataMovimentacao;
}
