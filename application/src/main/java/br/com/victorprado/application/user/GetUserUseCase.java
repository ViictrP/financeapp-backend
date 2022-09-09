package br.com.victorprado.application.user;

import br.com.victorprado.core.entity.User;
import br.com.victorprado.core.repository.UserRepository;
import br.com.victorprado.core.usercase.user.ICreateUserUseCase;
import br.com.victorprado.core.usercase.user.IGetUserUseCase;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class GetUserUseCase implements IGetUserUseCase,
  ICreateUserUseCase {

  private final UserRepository repository;

  @Override
  public Optional<User> get(Long id) {
    log.info("searching for user by id {}", id);
    return repository.findById(id);
  }

  @Override
  public User create(User user) {
    return repository.save(user);
  }
}
