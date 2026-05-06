package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Transacoes;

public class DaoTransacoes extends Dao<Transacoes> {
    @Override
    public Class<Transacoes> getEntity() {
        return Transacoes.class;
    }

    @Override
    public String atributoSelect() {
        return "tipoTransacao";
    }

    @Override
    public int nAtributos() {
        return 2;
    }
}
