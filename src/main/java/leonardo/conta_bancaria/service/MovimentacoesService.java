package leonardo.conta_bancaria.service;

import leonardo.conta_bancaria.dao.*;
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
    private Scanner in =  new Scanner(System.in).useLocale(Locale.US);

    public void transacao(int conta) {
        System.out.println("Escolha o tipo da transacao:");
        daoTransacoes.selectAll().forEach(i -> System.out.println(i));
        boolean valido = false;
        int transacao;
        while (!valido) {
            transacao = in.nextInt();
            in.nextLine();
            if (daoTransacoes.select(transacao) != null)
                valido = true;
            else
                System.out.println("Digite um numero valido");
        }
        BigDecimal valorTransacao;
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
    }

}
