package leonardo.conta_bancaria.service;

import leonardo.conta_bancaria.dao.*;
import leonardo.conta_bancaria.dto.*;
import leonardo.conta_bancaria.model.*;
import leonardo.conta_bancaria.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ContaService {
    @Autowired
    private DaoContas daoContas;
    @Autowired
    private DaoAgencias daoAgencias;
    @Autowired
    private Views view;
    private Scanner in =  new Scanner(System.in);
    @Autowired
    private Util util;
    @Autowired
    private DaoMovimentacoes daoMovimentacoes;
    @Autowired
    private DaoInvestidos daoInvestidos;
    @Autowired
    private DaoInvestimentos daoInvestimentos;
    @Autowired
    private DaoTransacoes daoTransacoes;

    public void novaConta(Clientes cliente, int banco) {
        try {
            ViewEnderecos endereco = view.selectEnderecoById(cliente.getIdEndereco());
            System.out.println("Selecione a agencia mais proxima de sua residencia:");
            util.mostrarAgencias(banco, endereco.getCidade());
            String linha;
            Agencias agencia;
            boolean valido = false;
            do {
                linha = in.nextLine();
                agencia = daoAgencias.select(linha);
                if (agencia == null)
                    System.out.println("Digite uma agencia valida:");
                else
                    valido = true;
            } while (!valido);
            Contas conta = new Contas(-1, util.gerarNum(4), cliente.getId(), agencia.getId(), util.data(), new BigDecimal(0));
            daoContas.insert(conta);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void extrato(Clientes conta) {
        Contas contab = daoContas.select(conta.getId());
        System.out.println("Saldo total: " + contab.getSaldo());
        List<Movimentacoes> mov = daoMovimentacoes.selectAll(contab.getId());
        List<Investidos> inv = daoInvestidos.selectAll(contab.getId());
        for (Investidos investido : inv)
            mov.add(new Movimentacoes(investido.getIdConta(), null, investido.getIdInvestimento(), investido.getValor(), investido.getDataInvestimento()));
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yy");
        mov.sort((d1, d2) -> {
            LocalDate data1 = LocalDate.parse(d1.getDataMovimentacao(), formatador);
            LocalDate data2 = LocalDate.parse(d2.getDataMovimentacao(), formatador);
            return data2.compareTo(data1);
        });
        for (Movimentacoes movimentacoes : mov) {
            System.out.println("-----");
            if (movimentacoes.getContadestino() == null) {
                System.out.println(daoInvestimentos.select(movimentacoes.getIdTransacao()).getTipoInvestimento());
                System.out.println("$" + movimentacoes.getValor() + " - " + movimentacoes.getDataMovimentacao());
            }
            else {
                System.out.println(daoTransacoes.select(movimentacoes.getIdTransacao()).getTipoTransacao());
                System.out.println(movimentacoes.getContadestino() + " - $" + movimentacoes.getValor() + " - " + movimentacoes.getDataMovimentacao());
            }
        }
    }

}
