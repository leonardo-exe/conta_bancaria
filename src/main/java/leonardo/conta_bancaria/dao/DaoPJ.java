package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.PJ;

public class DaoPJ extends Dao<PJ> {
    @Override
    public Class<PJ> getEntity() {
        return PJ.class;
    }

    @Override
    public String atributoSelect() {
        return "CNPJ";
    }

    @Override
    public int nAtributos() {
        return 3;
    }
}
