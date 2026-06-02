package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Investidos;
import leonardo.conta_bancaria.model.Movimentacoes;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Investidos> selectAll(Object value) {
        String sql = "select * from Investidos where id_conta = ?";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(Investidos.class), value);
    }

}
