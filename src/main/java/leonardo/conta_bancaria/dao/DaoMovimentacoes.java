package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Movimentacoes;

public class DaoMovimentacoes extends Dao<Movimentacoes> {

    @Override
    public Class<Movimentacoes> getEntity() {
        return Movimentacoes.class;
    }

    @Override
    public String atributoSelect() {
        return "idConta1";
    }

    @Override
    public int nAtributos() {
        return 5;
    }
}
