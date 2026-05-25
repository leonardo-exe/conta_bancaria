package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.PJ;
import org.springframework.stereotype.Repository;

@Repository
public class DaoPJ extends Dao<PJ> {
    @Override
    public Class<PJ> getEntity() {
        return PJ.class;
    }

    @Override
    public String atributoSelect() {
        return "cnpj";
    }
}
