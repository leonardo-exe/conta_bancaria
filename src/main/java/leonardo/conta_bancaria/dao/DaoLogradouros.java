package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Logradouros;
import org.springframework.stereotype.Repository;

@Repository
public class DaoLogradouros extends Dao<Logradouros> {
    @Override
    public Class<Logradouros> getEntity() {
        return Logradouros.class;
    }

    @Override
    public String atributoSelect() {
        return "logradouro";
    }

}
