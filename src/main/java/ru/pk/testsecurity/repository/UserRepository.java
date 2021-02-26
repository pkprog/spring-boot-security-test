package ru.pk.testsecurity.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.pk.testsecurity.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
