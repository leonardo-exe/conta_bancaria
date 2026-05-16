package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Clientes;
import org.springframework.stereotype.Repository;

@Repository
public class DaoClientes extends Dao<Clientes> {
    @Override
    public Class<Clientes> getEntity() {
        return Clientes.class;
    }

    @Override
    public String atributoSelect() {
        return "id";
    }


}
