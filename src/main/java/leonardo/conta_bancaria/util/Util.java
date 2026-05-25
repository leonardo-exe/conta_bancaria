package leonardo.conta_bancaria.util;

import leonardo.conta_bancaria.dao.Views;
import leonardo.conta_bancaria.dto.EnderecoAgencias;
import leonardo.conta_bancaria.dto.ViewBancos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class Util {
    private Random random = new Random();
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
        List<EnderecoAgencias> listFilter = list.stream().filter(i -> i.getCidade().equals(cidade)).collect(Collectors.toList());
        if (listFilter.isEmpty())
            list.forEach(System.out::println);
        else
            listFilter.forEach(System.out::println);
    }

    public String data() {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        return dataAtual.format(formatter);
    }
}
