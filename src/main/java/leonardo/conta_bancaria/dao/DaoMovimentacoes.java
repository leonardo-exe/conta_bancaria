package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Movimentacoes;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DaoMovimentacoes extends Dao<Movimentacoes> {

    @Override
    public Class<Movimentacoes> getEntity() {
        return Movimentacoes.class;
    }

    @Override
    public String atributoSelect() {
        return "idConta";
    }

    public List<Movimentacoes> selectAll(Object value) {
        String sql = "select * from movimentacoes where id_conta = ?";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(Movimentacoes.class), value);
    }

}
