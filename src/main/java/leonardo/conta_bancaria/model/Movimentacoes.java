package leonardo.conta_bancaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Movimentacoes {
    int id_conta1;
    int id_conta2;
    int id_transacao;
    BigDecimal valor;
    String data_movimentacao;
}
