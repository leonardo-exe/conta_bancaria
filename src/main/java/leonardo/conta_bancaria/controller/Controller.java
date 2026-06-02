package leonardo.conta_bancaria.controller;

import leonardo.conta_bancaria.model.Clientes;
import leonardo.conta_bancaria.service.AgenciaService;
import leonardo.conta_bancaria.service.AuthService;
import leonardo.conta_bancaria.service.ContaService;
import leonardo.conta_bancaria.service.MovimentacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
public class Controller {
    @Autowired
    AuthService authService;
    @Autowired
    MovimentacoesService movimentacoesService;
    @Autowired
    AgenciaService agenciaService;
    @Autowired
    ContaService contaService;
    private Clientes contaAtual;
    private Scanner scanner = new Scanner(System.in);
    public void init() {
        while (true) {
            System.out.println("\n-----SISTEMA BANCARIO NIMU-----\n");
            System.out.println("0-Fechar programa");
            System.out.println("1-Cadastre-se");
            System.out.println("2-Acessar");
            System.out.println("3-Agencia");
            int entrada = valida(scanner.nextLine(), 3);
            switch (entrada) {
                case -1 -> { break; }
                case 0 -> { return; }
                case 1 -> { contaAtual = authService.cadastro('u'); init(); }
                case 2 -> { contaAtual = authService.login(); if (contaAtual == null) init(); }
                case 3 -> {
                    System.out.println("0-Fechar programa");
                    System.out.println("1-Cadastrar banco");
                    System.out.println("2-Cadastrar agencia");
                    entrada = valida(scanner.nextLine(), 2);
                    switch (entrada) {
                        case -1 -> { init(); }
                        case 0 -> { return; }
                        case 1 -> { agenciaService.cadastrarBanco(); }
                        case 2 -> { agenciaService.cadastrarAgencia(); }
                    }
                }
            }
            while (true) {
                System.out.println("\n-----SISTEMA BANCARIO NIMU-----\n");
                System.out.println("0-Fechar programa");
                System.out.println("1-Extrato bancario");
                System.out.println("2-Realizar Transacao");
                System.out.println("3-Investir");
                entrada  = valida(scanner.nextLine(), 3);
                switch (entrada) {
                    case -1 -> { break; }
                    case 0 -> { return; }
                    case 1 -> { contaService.extrato(contaAtual); }
                    case 2 -> { movimentacoesService.transacao(contaAtual); }
                    case 3 -> { movimentacoesService.investimento(contaAtual); }
                }
            }
        }
    }
    private int valida(String str, int limite) {
        try {
            int escolha = Integer.parseInt(str.substring(0, 1));
            if (escolha > limite)
                throw new NumberFormatException();
            else
                return escolha;
        }
        catch (NumberFormatException e) {
            System.out.println("Digite um numero valido!");
            return -1;
        }
    }
}
