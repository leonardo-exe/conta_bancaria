package leonardo.conta_bancaria.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Transacoes {
    int id;
    String tipoTransacao;

    @Override
    public String toString() {
        return id + " - " + tipoTransacao;
    }
}
