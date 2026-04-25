package controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SpringBootApplication
public class StartApp {

    public static void main(String[] args) {
        SpringApplication.run(controllers.StartApp.class, args);
    }

    /**
     * Ten Bean "oszukuje" system. DataLoader2 chce PasswordEncoder, 
     * więc dajemy mu taki, który nic nie szyfruje.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}