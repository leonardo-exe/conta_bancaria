package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.PF;

public class DaoPF extends Dao<PF> {
    @Override
    public Class<PF> getEntity() {
        return PF.class;
    }

    @Override
    public String atributoSelect() {
        return "CPF";
    }

    @Override
    public int nAtributos() {
        return 4;
    }
}
