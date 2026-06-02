package leonardo.conta_bancaria;

import leonardo.conta_bancaria.controller.Controller;
import leonardo.conta_bancaria.dao.*;
import leonardo.conta_bancaria.dto.*;
import leonardo.conta_bancaria.model.*;
import leonardo.conta_bancaria.service.*;
import org.jspecify.annotations.NullMarked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ContaBancariaApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ContaBancariaApplication.class, args);
    }

    @Autowired
    private Controller controller;

    @Override
    @NullMarked
    public void run(String... args) throws Exception {
        controller.init();
    }
}
