package br.com.victorprado.config.infra;

import br.com.victorprado.core.repository.UserRepository;
import br.com.victorprado.postgres.repository.AuthenticationUserPostgresRepositoryImpl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

  @PersistenceContext
  private EntityManager entityManager;

  @Bean
  public UserRepository iAuthenticationUserRepository() {
    return new AuthenticationUserPostgresRepositoryImpl(entityManager);
  }
}
