package br.com.victorprado.infra.postgres.repository;

import br.com.victorprado.core.entity.User;
import br.com.victorprado.core.exceptions.NotFoundException;
import br.com.victorprado.core.repository.UserRepository;
import br.com.victorprado.infra.model.AuthenticationUser;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class AuthenticationUserPostgresRepositoryImpl implements UserRepository {

  private final IAuthenticationUserRepository repository;

  @Override
  public Optional<User> findById(Long id) {
    try {
      log.info("querying user by id {}", id);
      AuthenticationUser authenticationUser = repository.findById(id).orElseThrow(NotFoundException::new);
      log.info("user found!, {}", authenticationUser.getName());
      User user = new User();
      user.setId(authenticationUser.getId());
      user.setName(authenticationUser.getName());
      user.setLastName(authenticationUser.getLastName());
      log.info("returning user data");
      return Optional.of(user);
    } catch (Exception exception) {
      log.info("an error occured {}", exception.getMessage());
      throw new NotFoundException(exception.getMessage());
    }
  }

  @Override
  public User save(User user) {
    try {
      AuthenticationUser authenticationUser = new AuthenticationUser();
      authenticationUser.setName(user.getName());
      authenticationUser.setLastName(user.getLastName());
      repository.save(authenticationUser);
      user.setId(authenticationUser.getId());
      return user;
    } catch (Exception exception) {
      throw new NotFoundException(exception.getMessage());
    }
  }
}
