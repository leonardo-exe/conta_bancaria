package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Enderecos;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoEnderecos extends Dao<Enderecos> {
    @Override
    public Class<Enderecos> getEntity() {
        return Enderecos.class;
    }

    @Override
    public String atributoSelect() {
        return "id";
    }

    public Integer queryId(Enderecos endereco) {
        String sql = "select id from Enderecos where numero = ? and id_logradouro = ?";
        List<Object> values = new ArrayList<>();
        values.add(endereco.getNumero());
        values.add(endereco.getId_logradouro());
        try {
            return jdbc.queryForObject(sql, values.toArray(), Integer.class);
        }
        catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

}
