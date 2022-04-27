package br.com.victorprado.config.application.usecase;

import br.com.victorprado.application.user.GetUserUseCaseUseCaseUseCase;
import br.com.victorprado.core.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class UserUseCasesConfig {

  private final UserRepository repository;

  @Bean
  public GetUserUseCaseUseCaseUseCase getUser() {
    return new GetUserUseCaseUseCaseUseCase(repository);
  }
}
