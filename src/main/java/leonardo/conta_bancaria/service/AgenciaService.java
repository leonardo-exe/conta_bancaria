package leonardo.conta_bancaria.service;
import leonardo.conta_bancaria.dao.*;
import leonardo.conta_bancaria.dto.EnderecoAgencias;
import leonardo.conta_bancaria.model.Agencias;
import leonardo.conta_bancaria.model.Bancos;
import leonardo.conta_bancaria.model.Clientes;
import leonardo.conta_bancaria.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
public class AgenciaService {
    private Scanner in =  new Scanner(System.in);
    @Autowired
    private AuthService authService;
    @Autowired
    private DaoAgencias daoAgencias;
    @Autowired
    private DaoClientes daoClientes;
    @Autowired
    private DaoBancos daoBancos;
    @Autowired
    private Util util;

    public void cadastrarBanco() {
        try {
            Bancos banco = new Bancos();
            banco.setId(authService.cadastro('b').getId());
            daoBancos.insert(banco);
            Clientes cliente = daoClientes.select(banco.getId());
            Agencias agencia =  new Agencias(-1, util.gerarNum(1), cliente.getIdEndereco(), banco.getId());
            daoAgencias.insert(agencia);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastrarAgencia() {
        try {
            System.out.println("Cadastro agência");
            int endereco = authService.criarEndereco();
            Agencias agencia = new Agencias(-1, util.gerarNum(1), endereco, 1);
            daoAgencias.insert(agencia);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
