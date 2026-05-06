package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Agencias;
import org.springframework.stereotype.Repository;

@Repository
public class DaoAgencias extends Dao<Agencias> {

    @Override
    public Class<Agencias> getEntity() {
        return Agencias.class;
    }

    @Override
    public String atributoSelect() {
        return "numero_agencia";
    }

    @Override
    public int nAtributos() {
        return 4;
    }
}
