package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Clientes;

public class DaoClientes extends Dao<Clientes>
{
    @Override
    public Class<Clientes> getEntity() {
        return Clientes.class;
    }

    @Override
    public String atributoSelect() {
        return "id";
    }

    @Override
    public int nAtributos() {
        return 3;
    }
}
