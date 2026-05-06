package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Bancos;

public class DaoBancos extends Dao<Bancos> {
    @Override
    public Class<Bancos> getEntity() {
        return Bancos.class;
    }

    @Override
    public String atributoSelect() {
        return "id";
    }

    @Override
    public int nAtributos() {
        return 1;
    }
}
