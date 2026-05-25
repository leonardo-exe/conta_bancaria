package leonardo.conta_bancaria.util;

import leonardo.conta_bancaria.dao.Views;
import leonardo.conta_bancaria.dto.EnderecoAgencias;
import leonardo.conta_bancaria.dto.ViewBancos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
public class Util {
    @Autowired
    private Random random;
    @Autowired
    private Views view;

    public String gerarNum(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                result += ((Integer)random.nextInt(10)).toString();
            }
            if (i != n - 1)
                result += " ";
        }
        return result;
    }

    public void mostrarBancos() {
        for (ViewBancos i : view.selectBancos())
            System.out.println(i.getId() + " " + i.getRazao());
    }

    public void mostrarAgencias(int banco, String cidade) {
        List<EnderecoAgencias> list = view.selectEnderecoAgencia(banco);
        list.stream().filter(x -> x.getCidade().equals(cidade)).forEach(System.out::println);
    }

    public String data() {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        return dataAtual.format(formatter);
    }
}
