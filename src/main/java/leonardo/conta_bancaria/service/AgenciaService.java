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
    @Autowired
    private Scanner in;
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
            System.out.println("Selecione o banco ao qual a agencia pertence:");
            util.mostrarBancos();
            boolean valido = false;
            int i;
            do {
                i = in.nextInt();
                in.nextLine();
                if (daoAgencias.selectId(i) == null)
                    System.out.println("Digite um numero valido");
                else
                    valido = true;
            } while (!valido);
            Agencias agencia = new Agencias(-1, util.gerarNum(1), endereco, i);
            daoAgencias.insert(agencia);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
