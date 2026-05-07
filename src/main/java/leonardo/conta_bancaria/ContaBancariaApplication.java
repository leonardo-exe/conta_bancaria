package leonardo.conta_bancaria;

import org.jspecify.annotations.NullMarked;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class ContaBancariaApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ContaBancariaApplication.class, args);
    }

    @Override
    @NullMarked
    public void run(String... args) throws Exception {

    }
}
