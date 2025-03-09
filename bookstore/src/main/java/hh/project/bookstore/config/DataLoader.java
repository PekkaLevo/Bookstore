package hh.project.bookstore.config;

import hh.project.bookstore.domain.AppUser;
import hh.project.bookstore.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            userRepository.deleteAll();

            String adminPassword = "admin123"; 
            String adminHash = passwordEncoder.encode(adminPassword);
            System.out.println("ADMIN password (plain): " + adminPassword);
            System.out.println("ADMIN password (hashed): " + adminHash);

            AppUser adminUser = new AppUser("admin", adminHash, "admin@example.com", "ADMIN");
            userRepository.save(adminUser);

            String userPassword = "user123"; 
            String userHash = passwordEncoder.encode(userPassword);
            System.out.println("USER password (plain): " + userPassword);
            System.out.println("USER password (hashed): " + userHash);

            AppUser normalUser = new AppUser("user", userHash, "user@example.com", "USER");
            userRepository.save(normalUser);
        };
    }
}