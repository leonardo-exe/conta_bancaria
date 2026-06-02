package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Contas;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class DaoContas extends Dao<Contas> {
    @Override
    public Class<Contas> getEntity() {
        return Contas.class;
    }

    @Override
    public String atributoSelect() {
        return "idCliente";
    }

    public void update(int id, BigDecimal saldo) {
        String sql = "update Contas set saldo = ? where id = ?";
        jdbc.update(sql, saldo, id);
    }

}
