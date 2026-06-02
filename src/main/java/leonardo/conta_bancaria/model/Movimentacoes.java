package leonardo.conta_bancaria.model;

import lombok.*;

import java.math.BigDecimal;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Movimentacoes {
    int idConta;
    String contadestino;
    int idTransacao;
    BigDecimal valor;
    String dataMovimentacao;
}
