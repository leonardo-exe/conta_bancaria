package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Logradouros;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DaoLogradouros extends Dao<Logradouros> {
    @Override
    public Class<Logradouros> getEntity() {
        return Logradouros.class;
    }

    @Override
    public String atributoSelect() {
        return "logradouro";
    }

    public Logradouros selectPorNomeEBairro(String nomeLogradouro, int idBairro) {
        try {
            String sql = "select * from logradouros where logradouro = ? and id_bairro = ?";
            return jdbc.queryForObject(sql, BeanPropertyRowMapper.newInstance(Logradouros.class), nomeLogradouro, idBairro);
        } catch (Exception e) {
            return null;
        }
    }
}
