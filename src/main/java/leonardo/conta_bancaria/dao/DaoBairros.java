package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Bairros;

public class DaoBairros extends Dao<Bairros> {
    @Override
    public Class<Bairros> getEntity() {
        return Bairros.class;
    }

    @Override
    public String atributoSelect() {
        return "bairro";
    }

    @Override
    public int nAtributos() {
        return 3;
    }
}
