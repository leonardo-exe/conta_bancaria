package leonardo.conta_bancaria.model;

import leonardo.conta_bancaria.dao.Dao;
import lombok.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Estados {
    String estado;
    String sigla;
}
