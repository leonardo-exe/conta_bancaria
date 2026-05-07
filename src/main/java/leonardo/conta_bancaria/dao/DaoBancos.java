package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Bancos;
import org.springframework.stereotype.Repository;

@Repository
public class DaoBancos extends Dao<Bancos> {
    @Override
    public Class<Bancos> getEntity() {
        return Bancos.class;
    }

    @Override
    public String atributoSelect() {
        return "id";
    }


}
