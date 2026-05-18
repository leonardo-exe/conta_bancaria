package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Agencias;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DaoAgencias extends Dao<Agencias> {

    @Override
    public Class<Agencias> getEntity() {
        return Agencias.class;
    }

    @Override
    public String atributoSelect() {
        return "numero_agencia";
    }

    public Agencias selectId(int n) {
        String sql = "select * from Agencias where id = ?";
        return jdbc.queryForObject(sql, BeanPropertyRowMapper.newInstance(Agencias.class), n);
    }

}
