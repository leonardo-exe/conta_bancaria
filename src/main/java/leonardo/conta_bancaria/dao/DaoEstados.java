package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Estados;
import org.springframework.stereotype.Repository;

@Repository
public class DaoEstados extends Dao<Estados> {
    @Override
    public Class<Estados> getEntity() {
        return Estados.class;
    }

    @Override
    public String atributoSelect() {
        return "sigla";
    }

}
