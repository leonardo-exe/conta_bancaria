package leonardo.conta_bancaria.service;

import leonardo.conta_bancaria.dao.DaoAgencias;
import leonardo.conta_bancaria.dao.DaoContas;
import leonardo.conta_bancaria.model.Agencias;
import leonardo.conta_bancaria.model.Contas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class ContaService {
    @Autowired
    private Random random;
    @Autowired
    private DaoContas daoContas;
    @Autowired
    private DaoAgencias daoAgencias;
    public void novaConta(int cliente, int banco) {
        //Contas conta = new Contas(-1, gerarNum(4), cliente, 1, );
    }

    public String gerarNum(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                result += ((Integer)random.nextInt(10)).toString();
            }
            result += " ";
        }
        return result;
    }

    private String dataAbertura() {
        LocalDate dataAbertura = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        return dataAbertura.format(formatter);
    }
}
