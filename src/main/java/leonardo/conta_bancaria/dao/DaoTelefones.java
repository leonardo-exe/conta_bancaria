package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Telefones;
import org.springframework.stereotype.Repository;

@Repository
public class DaoTelefones extends Dao<Telefones> {
    @Override
    public Class<Telefones> getEntity() {
        return Telefones.class;
    }

    @Override
    public String atributoSelect() {
        return "numero";
    }


}
