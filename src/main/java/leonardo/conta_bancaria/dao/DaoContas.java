package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Contas;

public class DaoContas extends Dao<Contas> {
    @Override
    public Class<Contas> getEntity() {
        return Contas.class;
    }

    @Override
    public String atributoSelect() {
        return "numeroConta";
    }

    @Override
    public int nAtributos() {
        return 5;
    }
}
