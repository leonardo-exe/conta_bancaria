package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Telefones;

public class DaoTelefones extends Dao<Telefones> {
    @Override
    public Class<Telefones> getEntity() {
        return Telefones.class;
    }

    @Override
    public String atributoSelect() {
        return "numero";
    }

    @Override
    public int nAtributos() {
        return 3;
    }
}
