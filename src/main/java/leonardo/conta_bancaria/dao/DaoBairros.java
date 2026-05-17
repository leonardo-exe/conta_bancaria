package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Bairros;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class DaoBairros extends Dao<Bairros> {
    @Override
    public Class<Bairros> getEntity() {
        return Bairros.class;
    }

    @Override
    public String atributoSelect() {
        return "bairro";
    }

    public Bairros selectPorNomeECidade(String nomeBairro, int idCidade) {
        try {
            String sql = "select * from bairros where bairro = ? and id_cidade = ?";
            return jdbc.queryForObject(sql, BeanPropertyRowMapper.newInstance(Bairros.class), nomeBairro, idCidade);
        } catch (Exception e) {
            return null;
        }
    }

}
