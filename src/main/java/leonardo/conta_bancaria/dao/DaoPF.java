package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.PF;
import org.springframework.stereotype.Repository;

@Repository
public class DaoPF extends Dao<PF> {
    @Override
    public Class<PF> getEntity() {
        return PF.class;
    }

    @Override
    public String atributoSelect() {
        return "cpf";
    }

}
