package leonardo.conta_bancaria.service;

import leonardo.conta_bancaria.dao.*;
import leonardo.conta_bancaria.dto.*;
import leonardo.conta_bancaria.model.*;
import leonardo.conta_bancaria.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
public class ContaService {
    @Autowired
    private DaoContas daoContas;
    @Autowired
    private DaoAgencias daoAgencias;
    @Autowired
    private Views view;
    @Autowired
    private Scanner in;
    @Autowired
    private Util util;

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
            Contas conta = new Contas(-1, util.gerarNum(4), cliente.getId(), agencia.getId(), util.data());
            daoContas.insert(conta);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
