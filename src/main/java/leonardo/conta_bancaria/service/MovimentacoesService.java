package leonardo.conta_bancaria.service;

import leonardo.conta_bancaria.dao.*;
import leonardo.conta_bancaria.model.*;
import leonardo.conta_bancaria.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

@Service
public class MovimentacoesService {
    @Autowired
    private DaoTransacoes daoTransacoes;
    @Autowired
    private DaoMovimentacoes daoMovimentacoes;
    @Autowired
    private DaoInvestimentos daoInvestimentos;
    @Autowired
    private DaoInvestidos daoInvestidos;
    @Autowired
    private Util util;
    @Autowired
    private DaoContas daoContas;
    private Scanner in =  new Scanner(System.in).useLocale(Locale.US);

    public void transacao(Clientes conta) {
        try {
            Movimentacoes movimentacoes = new Movimentacoes();
            movimentacoes.setIdConta(daoContas.select(conta.getId()).getId());
            System.out.println("Escolha o tipo da transacao:");
            daoTransacoes.selectAll().forEach(i -> System.out.println(i));
            boolean valido = false;
            int transacao = 0;
            while (!valido) {
                transacao = in.nextInt();
                in.nextLine();
                if (daoTransacoes.select(transacao) != null)
                    valido = true;
                else
                    System.out.println("Digite um numero valido");
            }
            movimentacoes.setIdTransacao(transacao);
            if (transacao == 1) { //pix
                System.out.println("Digite a chave pix do destinatario:");
                movimentacoes.setContadestino(in.nextLine());
            } else if (transacao == 4) { //boleto
                System.out.println("Digite o código de barras do boleto");
                movimentacoes.setContadestino(in.nextLine());
            } else {
                System.out.println("Digite o numero da conta de destino da transacao:");
                movimentacoes.setContadestino(in.nextLine());
            }
            BigDecimal valorTransacao = new BigDecimal(0);
            valido = false;
            while (!valido) {
                System.out.println("Digite o valor da transacao:");
                valorTransacao = in.nextBigDecimal();
                in.nextLine();
                System.out.println("Confirmar valor: " + valorTransacao + " (S/N)");
                char caracter = Character.toUpperCase(in.nextLine().charAt(0));
                if (caracter == 'S')
                    valido = true;
            }
            Contas contab = daoContas.select(conta.getId());
            movimentacoes.setValor(valorTransacao);
            movimentacoes.setDataMovimentacao(util.data());
            daoMovimentacoes.insert((movimentacoes));
            daoContas.update(contab.getId(), contab.getSaldo().subtract(valorTransacao));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void investimento(Clientes conta) {
        try {
            Investidos investidos = new Investidos();
            investidos.setIdConta(daoContas.select(conta.getId()).getId());
            System.out.println("Escolha o tipo de investimento:");
            daoInvestimentos.selectAll().forEach(i -> System.out.println(i));
            boolean valido = false;
            int investimento = 0;
            while (!valido) {
                investimento = in.nextInt();
                in.nextLine();
                if (daoInvestimentos.select(investimento) != null)
                    valido = true;
                else
                    System.out.println("Digite um numero valido");
            }
            investidos.setIdInvestimento(investimento);
            BigDecimal valorInvestimento = new BigDecimal(0);
            valido = false;
            while (!valido) {
                System.out.println("Digite o valor a ser investido:");
                valorInvestimento = in.nextBigDecimal();
                in.nextLine();
                System.out.println("Confirmar valor: " + valorInvestimento + " (S/N)");
                char caracter = Character.toUpperCase(in.nextLine().charAt(0));
                if (caracter == 'S')
                    valido = true;
            }
            Contas contab = daoContas.select(conta.getId());
            investidos.setValor(valorInvestimento);
            investidos.setDataInvestimento(util.data());
            daoInvestidos.insert(investidos);
            daoContas.update(contab.getId(), contab.getSaldo().subtract(valorInvestimento));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
