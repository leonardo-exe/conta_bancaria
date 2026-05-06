package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Investidos;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public class DaoInvestidos extends Dao<Investidos> {
    @Override
    public Class<Investidos> getEntity() {
        return Investidos.class;
    }

    @Override
    public String atributoSelect() {
        return "idConta";
    }

    @Override
    public int nAtributos() {
        return 4;
    }
}
