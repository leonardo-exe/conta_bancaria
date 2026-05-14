package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Bairros;
import leonardo.conta_bancaria.model.Cidades;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public String toString(int cidade) {
        List<Bairros> list = selectAll();
        List<String> result =  new ArrayList<>();
        for (Bairros bairro : list) {
            if (bairro.getIdCidade() == cidade)
                result.add(bairro.getBairro());
        }
        result.sort(Comparator.naturalOrder());
        return String.join("\n", result);
    }

}
