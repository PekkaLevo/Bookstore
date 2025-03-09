package hh.project.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hh.project.bookstore.domain.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
