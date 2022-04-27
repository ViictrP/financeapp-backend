package br.com.victorprado.core.repository;

import br.com.victorprado.core.entity.User;
import java.util.Optional;

public interface UserRepository {

  Optional<User> findById(Long id);
  User save(User user);
}
