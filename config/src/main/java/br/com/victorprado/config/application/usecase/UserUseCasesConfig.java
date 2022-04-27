package br.com.victorprado.config.application.usecase;

import br.com.victorprado.application.user.GetUser;
import br.com.victorprado.core.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class UserUseCasesConfig {

  private final UserRepository repository;

  @Bean
  public GetUser getUser() {
    return new GetUser(repository);
  }
}
