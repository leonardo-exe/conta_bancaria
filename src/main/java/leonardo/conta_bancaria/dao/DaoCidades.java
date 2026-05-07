package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Cidades;
import org.springframework.stereotype.Repository;

@Repository
public class DaoCidades extends Dao<Cidades> {
    @Override
    public Class<Cidades> getEntity() {
        return Cidades.class;
    }

    @Override
    public String atributoSelect() {
        return "cidade";
    }


}
