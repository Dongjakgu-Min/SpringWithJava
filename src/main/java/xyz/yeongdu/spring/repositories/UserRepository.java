package xyz.yeongdu.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.yeongdu.spring.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
