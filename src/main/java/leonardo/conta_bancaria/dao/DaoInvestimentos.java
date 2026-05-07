package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Investimentos;
import org.springframework.stereotype.Repository;

@Repository
public class DaoInvestimentos extends Dao<Investimentos> {
    @Override
    public Class<Investimentos> getEntity() {
        return Investimentos.class;
    }

    @Override
    public String atributoSelect() {
        return "tipoInvestimento";
    }

}
