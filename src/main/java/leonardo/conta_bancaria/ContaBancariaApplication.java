package leonardo.conta_bancaria;

import leonardo.conta_bancaria.dao.*;
import leonardo.conta_bancaria.model.*;
import leonardo.conta_bancaria.service.EnderecoService;
import org.jspecify.annotations.NullMarked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;

@SpringBootApplication
public class ContaBancariaApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ContaBancariaApplication.class, args);
    }

    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private DaoCidades daoCidades;

    @Override
    @NullMarked
    public void run(String... args) throws Exception {
        File arquivo = new File("/home/leonardo/programas/java/trabalho1_BD/conta_bancaria/src/main/java/leonardo/conta_bancaria/cidades_brasil.txt");
        enderecoService.insertCEP("85862259");

    }
}
