package br.com.victorprado.config.infra;

import br.com.victorprado.core.repository.UserRepository;
import br.com.victorprado.infra.postgres.repository.AuthenticationUserPostgresRepositoryImpl;
import br.com.victorprado.infra.postgres.repository.IAuthenticationUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

  private IAuthenticationUserRepository repository;

  @Bean
  public UserRepository iAuthenticationUserRepository() {
    return new AuthenticationUserPostgresRepositoryImpl(repository);
  }
}
