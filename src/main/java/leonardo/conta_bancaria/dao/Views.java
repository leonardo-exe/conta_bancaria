package leonardo.conta_bancaria.dao;

import leonardo.conta_bancaria.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Views {
    @Autowired
    private JdbcTemplate jdbc;

    public List<ViewBancos> selectBancos() {
        String sql = "select * from view_bancos";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(ViewBancos.class));
    }

    public List<ViewEnderecos> selectEnderecos() {
        String sql = "select * from view_enderecos";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(ViewEnderecos.class));
    }

    public List<EnderecoAgencias> selectEnderecoAgencia(int banco) {
        String sql = "select * from endereco_agencias where id_banco = ?";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(EnderecoAgencias.class), banco);
    }

    public ViewEnderecos selectEnderecoById(int id) {
        String sql = "select * from view_enderecos where id = ?";
        return jdbc.queryForObject(sql, BeanPropertyRowMapper.newInstance(ViewEnderecos.class), id);
    }
}
