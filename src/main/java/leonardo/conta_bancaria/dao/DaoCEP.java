package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.CEP;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoCEP extends Dao<CEP> {
    @Override
    public Class<CEP> getEntity() {
        return CEP.class;
    }

    @Override
    public String atributoSelect() {
        return "CEP";
    }

    @Override
    public void insert(CEP object) {
        String sql = "insert into CEP (CEP, id_logradouro) values (?, ?) ";
        List<Object> values = new ArrayList<>();
        values.add(object.getCEP());
        values.add(object.getIdLogradouro());
        jdbc.update(sql, values.toArray());
    }
}
