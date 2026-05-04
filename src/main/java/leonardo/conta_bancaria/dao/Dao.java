package leonardo.conta_bancaria.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class Dao<t> {
    @Autowired
    protected JdbcTemplate jdbcTemplate;
    public abstract String getSqlInsert();
    public void insert(t object) {
        List<Object> values = new ArrayList<>();
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getName().equals("id"))
                    continue;
                values.add(field.get(object));
                field.setAccessible(false);
            }
            jdbcTemplate.update(getSqlInsert(), values.toArray());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public List<t> selectAll(Class<t> type) {
        String sql = "SELECT * FROM " + type.getSimpleName();
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(type));
    }
}
