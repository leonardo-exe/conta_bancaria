package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Cidades;

public class DaoCidades extends Dao<Cidades>{
    @Override
    public Class<Cidades> getEntity() {
        return Cidades.class;
    }

    @Override
    public String atributoSelect() {
        return "cidade";
    }

    @Override
    public int nAtributos() {
        return 3;
    }
}
