package leonardo.conta_bancaria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

@Repository
public abstract class Dao<t> {
    @Autowired
    protected JdbcTemplate jdbc;
    private String table = getEntity().getSimpleName();

    public abstract Class<t> getEntity();

    public abstract String atributoSelect();

    public int nAtributos() {
        try {
            Field[] fields = getEntity().getDeclaredFields();
            return fields.length;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    public String to_snake_case(String str) {
        String result = "";
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c))
                result += "_" + Character.toLowerCase(c);

            else
                result += c;
        }
        return result;
    }

    public int insert(t object) throws Exception {
        String sql = "insert into " + table + " (";
        String sqlAux = "values (";
        List<Object> values = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        int size = nAtributos();
        for (int i = 0; i < size; i++) {
            fields[i].setAccessible(true);
            if (!fields[i].getName().equals("id")) {
                sql += to_snake_case(fields[i].getName());
                sqlAux += "?";
                values.add(fields[i].get(object));
                if (i != size - 1) {
                    sql += ", ";
                    sqlAux += ", ";
                }
            }
            fields[i].setAccessible(false);
        }
        sql += ") " + sqlAux + ")";
        final String finalSql = sql;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(finalSql, Statement.RETURN_GENERATED_KEYS);
                for (int idx = 0; idx < values.size(); idx++) {
                    ps.setObject(idx + 1, values.get(idx));
                }
                return ps;
            }
        }, keyHolder);
        if (keyHolder.getKeys() != null &&  !keyHolder.getKeys().isEmpty()) {
            Map<String, Object> keys = keyHolder.getKeys();
            Integer id = (Integer)keys.get("id");
            if (id != null)
                return id.intValue();
            else
                return 0;
        }
        return -1;
    }

    public void update(t object) throws Exception {
        String sql = "update " + table + " set ";
        Field[] fields = object.getClass().getDeclaredFields();
        List<Object> values = new ArrayList<Object>();
        int size = nAtributos();
        for (int i = 0; i < size; i++) {
            if (!fields[i].getName().equals("id")) {
                fields[i].setAccessible(true);
                values.add(fields[i].get(object));
                sql += to_snake_case(fields[i].getName()) + " = ?";
                if (i != size - 1)
                    sql += ", ";
                fields[i].setAccessible(false);
            }
        }
        values.add(object.getClass().getDeclaredField(atributoSelect()).get(object));
        sql += "where " + atributoSelect() + " = ?";
        jdbc.update(sql, values.toArray());
    }

    public void delete(t object) throws Exception {
        String sql = "delete from " + table + " where " + to_snake_case(atributoSelect()) + " = ?";

        Field field = object.getClass().getDeclaredField(atributoSelect());
        field.setAccessible(true);
        jdbc.update(sql, field.getInt(object));
        field.setAccessible(false);

    }

    public t select(Object value) {
        try {
            String sql = "select * from " + table + " where " + to_snake_case(atributoSelect()) + " = ?";
            return jdbc.queryForObject(sql, BeanPropertyRowMapper.newInstance(getEntity()), value);
        }
        catch (Exception e) {
            return null;
        }
    }

    public List<t> selectAll() {
        String sql = "select * from " + table;
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(getEntity()));
    }

}
