package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Estados;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class DaoEstados extends Dao<Estados> {
    @Override
    public Class<Estados> getEntity() {
        return Estados.class;
    }

    @Override
    public String atributoSelect() {
        return "estado";
    }

    public String toString() {
        List<Estados> list = selectAll();
        List<String> strings = new ArrayList<>();
        for (Estados estado : list) {
            strings.add(estado.getSigla() + " - " + estado.getEstado());
        }
        strings.sort(Comparator.naturalOrder());
        return String.join("\n", strings);
    }
}
