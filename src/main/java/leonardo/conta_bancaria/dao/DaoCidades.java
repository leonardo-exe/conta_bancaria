package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Cidades;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class DaoCidades extends Dao<Cidades> {
    @Override
    public Class<Cidades> getEntity() {
        return Cidades.class;
    }

    @Override
    public String atributoSelect() {
        return "cidade";
    }

    public String toString(String estado) {
        List<Cidades> list = selectAll();
        List<String> result =  new ArrayList<>();
        for (Cidades cidade : list) {
            if (cidade.getSiglaEstado().equals(estado))
                result.add(cidade.getCidade());
        }
        result.sort(Comparator.naturalOrder());
        return String.join("\n", result);
    }
}
