package com.possacode.digitalbanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DigitalbankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalbankingApplication.class, args);
    }

}
