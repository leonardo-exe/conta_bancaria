package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Emails;
import org.springframework.stereotype.Repository;

@Repository
public class DaoEmails extends Dao<Emails> {
    @Override
    public Class<Emails> getEntity() {
        return Emails.class;
    }

    @Override
    public String atributoSelect() {
        return "email";
    }

}
