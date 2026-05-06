package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.CEP;

public class DaoCEP extends Dao<CEP> {
    @Override
    public Class<CEP> getEntity() {
        return CEP.class;
    }

    @Override
    public String atributoSelect() {
        return "CEP";
    }

    @Override
    public int nAtributos() {
        return 2;
    }
}
