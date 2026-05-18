package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.dto.BancosDTO;
import leonardo.conta_bancaria.model.Bancos;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

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

    public List<BancosDTO> view() {
        String sql = "select * from View_Bancos";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(BancosDTO.class));
    }
}
