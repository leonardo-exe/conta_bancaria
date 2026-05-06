package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Investimentos;

public class DaoInvestimentos extends Dao<Investimentos> {
    @Override
    public Class<Investimentos> getEntity() {
        return Investimentos.class;
    }

    @Override
    public String atributoSelect() {
        return "tipoInvestimento";
    }

    @Override
    public int nAtributos() {
        return 3;
    }
}
