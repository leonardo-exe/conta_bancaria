package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Enderecos;
import org.springframework.stereotype.Repository;

@Repository
public class DaoEnderecos extends Dao<Enderecos> {
    @Override
    public Class<Enderecos> getEntity() {
        return Enderecos.class;
    }

    @Override
    public String atributoSelect() {
        return "id";
    }

}
