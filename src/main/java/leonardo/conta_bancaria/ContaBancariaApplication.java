package leonardo.conta_bancaria;

import leonardo.conta_bancaria.dao.DaoAgencias;
import leonardo.conta_bancaria.model.Agencias;
import org.jspecify.annotations.NullMarked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class ContaBancariaApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ContaBancariaApplication.class, args);
	}
	@Autowired
    DaoAgencias daoAgencias;
	@Override
	@NullMarked
	public void run(String... args) throws Exception {
		Agencias agencias = new Agencias(1, "teste", -1, 85);
		daoAgencias.insert(agencias);
	}
}
