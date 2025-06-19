package dev.project.userservice.repository;

import dev.project.userservice.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Token save(Token token);
  Optional<Token> findByValueAndDeletedEquals(String Value, boolean deleted);
    Optional<Token> findByValueAndDeletedEqualsAndExpiryAtGreaterThan(String value, boolean isDeleted, Date expiryGreaterThan);

}
