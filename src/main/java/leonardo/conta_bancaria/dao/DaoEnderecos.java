package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Enderecos;

public class DaoEnderecos extends Dao<Enderecos> {
    @Override
    public Class<Enderecos> getEntity() {
        return Enderecos.class;
    }

    @Override
    public String atributoSelect() {
        return "id";
    }

    @Override
    public int nAtributos() {
        return 4;
    }
}
