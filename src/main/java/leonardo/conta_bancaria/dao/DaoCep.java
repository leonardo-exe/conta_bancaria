package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Cep;
import org.springframework.stereotype.Repository;

@Repository
public class DaoCep extends Dao<Cep> {
    @Override
    public Class<Cep> getEntity() {
        return Cep.class;
    }

    @Override
    public String atributoSelect() {
        return "cep";
    }
}
