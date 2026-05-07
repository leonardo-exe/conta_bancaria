package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.CEP;
import org.springframework.stereotype.Repository;

@Repository
public class DaoCEP extends Dao<CEP> {
    @Override
    public Class<CEP> getEntity() {
        return CEP.class;
    }

    @Override
    public String atributoSelect() {
        return "CEP";
    }


}
