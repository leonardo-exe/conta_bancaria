package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Estados;

public class DaoEstados extends Dao<Estados> {
    @Override
    public Class<Estados> getEntity() {
        return Estados.class;
    }

    @Override
    public String atributoSelect() {
        return "sigla";
    }

    @Override
    public int nAtributos() {
        return 2;
    }
}
