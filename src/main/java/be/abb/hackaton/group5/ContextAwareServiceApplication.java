package be.abb.hackaton.group5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"be.abb.hackaton.group5"})
public class ContextAwareServiceApplication {

    public static void main (String[] args){
        SpringApplication.run(ContextAwareServiceApplication.class, args);
    }
}
