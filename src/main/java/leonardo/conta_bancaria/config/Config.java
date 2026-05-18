package leonardo.conta_bancaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Random;
import java.util.Scanner;

@Configuration
public class Config {
    @Bean
    public Random random() {
        return new Random();
    }
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
