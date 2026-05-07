package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Investidos;
import org.springframework.stereotype.Repository;

@Repository
public class DaoInvestidos extends Dao<Investidos> {
    @Override
    public Class<Investidos> getEntity() {
        return Investidos.class;
    }

    @Override
    public String atributoSelect() {
        return "idConta";
    }

}
