package br.com.victorprado.core.usercase.user;

import br.com.victorprado.core.entity.User;
import java.util.Optional;

public interface IGetUserUseCase {
  Optional<User> get(Long id);
}
