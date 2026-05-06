package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.model.Emails;

public class DaoEmails extends Dao<Emails> {
    @Override
    public Class<Emails> getEntity() {
        return Emails.class;
    }

    @Override
    public String atributoSelect() {
        return "email";
    }

    @Override
    public int nAtributos() {
        return 2;
    }
}
