package leonardo.conta_bancaria.service;

import leonardo.conta_bancaria.model.*;
import leonardo.conta_bancaria.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
public class AuthService {
    private Scanner in =  new Scanner(System.in);
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private DaoClientes daoClientes;
    @Autowired
    private DaoPF daoPF;
    @Autowired
    private DaoPJ daoPJ;
    public void cadastro() {
        Clientes cliente = new Clientes();
        do {
            System.out.println("Sera criada uma conta para PJ ou PF? (F/J)");
            cliente.setTipoPessoa(in.nextLine().toUpperCase());
        } while (!cliente.getTipoPessoa().equals("F") && !cliente.getTipoPessoa().equals("J"));

        cliente.setIdEndereco(criarEndereco());
        try {
            int id = daoClientes.insert(cliente);
            if (cliente.getTipoPessoa().equals("F")) {
                PF pf = criarPF();
                pf.setIdCliente(id);
                daoPF.insert(pf);
            }
            else {
                PJ pj = criarPJ();
                pj.setIdCliente(id);
                daoPJ.insert(pj);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }
    private PF criarPF() {
        PF pf = new PF();
        System.out.println("Digite o seu nome completo:");
        pf.setNome(in.nextLine());
        System.out.println("Digite o seu CPF:");
        pf.setCpf(in.nextLine());
        System.out.println("Digite o seu RG:");
        pf.setRg(in.nextLine());
        return pf;
    }
    private PJ criarPJ() {
        PJ pj = new PJ();
        System.out.println("Digite a razao social da empresa:");
        pj.setRazao(in.nextLine());
        System.out.println("Digite o CNPJ da empresa:");
        pj.setCnpj(in.nextLine());
        return pj;
    }
    private int criarEndereco() {
        String cep, logradouro, complemento;
        int numero, id;
        do {
            System.out.println("Cadastro de endereco");
            System.out.println("Digite o CEP:");
            cep = in.nextLine();
            System.out.println("Digite o nome do logradouro: (Rua, Avenida, etc)");
            logradouro = in.nextLine();
            System.out.println("Digite o numero predial:");
            numero = in.nextInt();
            System.out.println("Digite o complemento:");
            complemento = in.nextLine();
            id = enderecoService.insertEndereco(cep, logradouro, numero, complemento);
        } while (id == -1);
        return id;
    }
}
