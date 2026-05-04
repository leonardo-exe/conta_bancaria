package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Agencias;
import org.springframework.stereotype.Repository;

@Repository
public class DaoAgencias extends Dao<Agencias> {
    @Override
    public String getSqlInsert() {
        return """
                insert into Agencias (numero_agencia, id_endereco, id_banco)
                values (?, ?, ?);
                """;
    }
}
