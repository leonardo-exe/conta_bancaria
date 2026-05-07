package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Transacoes;
import org.springframework.stereotype.Repository;

@Repository
public class DaoTransacoes extends Dao<Transacoes> {
    @Override
    public Class<Transacoes> getEntity() {
        return Transacoes.class;
    }

    @Override
    public String atributoSelect() {
        return "tipoTransacao";
    }

}
