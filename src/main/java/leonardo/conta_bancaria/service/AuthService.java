package leonardo.conta_bancaria.service;

import leonardo.conta_bancaria.model.*;
import leonardo.conta_bancaria.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class AuthService {
    private Scanner in = new Scanner(System.in);
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private DaoClientes daoClientes;
    @Autowired
    private DaoPF daoPF;
    @Autowired
    private DaoPJ daoPJ;
    @Autowired
    private DaoEmails daoEmails;
    @Autowired
    private DaoTelefones daoTelefones;
    @Autowired
    private ContaService contaService;

    public int cadastro() {
        Clientes cliente = new Clientes();
        do {
            System.out.println("Sera criada uma conta para PJ ou PF? (F/J)");
            cliente.setTipoPessoa(in.nextLine().toUpperCase());
        } while (!cliente.getTipoPessoa().equals("F") && !cliente.getTipoPessoa().equals("J"));
        try {
            PF pf = new PF();
            PJ pj = new PJ();
            if (cliente.getTipoPessoa().equals("F"))
                pf = criarPF();
            else
                pj = criarPJ();
            cliente.setIdEndereco(criarEndereco());
            int id = daoClientes.insert(cliente);
            if (cliente.getTipoPessoa().equals("F")) {
                pf.setIdCliente(id);
                daoPF.insert(pf);
            } else {
                pj.setIdCliente(id);
                daoPJ.insert(pj);
            }
            Emails email = criarEmail();
            email.setIdCliente(id);
            daoEmails.insert(email);
            Telefones telefones = criarTelefone();
            telefones.setIdCliente(id);
            daoTelefones.insert(telefones);
            contaService.novaConta(id);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private Telefones criarTelefone() {
        System.out.println("Digite o numero de telefone com DDD no seguinte formato: (### #########)");
        boolean confirmado = false;
        Telefones telefone = new Telefones();
        while (!confirmado) {
            String numero = in.nextLine().replace(" ", "");
            telefone.setDdd(numero.substring(0, 3));
            telefone.setNumero(numero.substring(3));
            System.out.println("Confirmar numero " + telefone.getDdd() + " " + telefone.getNumero() + "? (S/N)");
            String resposta = in.nextLine().toUpperCase();
            if (resposta.equals("S"))
                confirmado = true;
        }
        return telefone;
    }

    private Emails criarEmail() {
        System.out.println("Digite seu email:");
        return new Emails(in.nextLine(), -1);
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
