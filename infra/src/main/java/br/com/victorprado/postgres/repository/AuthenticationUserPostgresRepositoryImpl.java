package br.com.victorprado.postgres.repository;

import br.com.victorprado.core.entity.User;
import br.com.victorprado.core.exceptions.NotFoundException;
import br.com.victorprado.core.repository.UserRepository;
import br.com.victorprado.model.AuthenticationUser;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticationUserPostgresRepositoryImpl implements UserRepository {

  private final EntityManager entityManager;

  @Override
  public Optional<User> findById(Long id) {
    try {
      AuthenticationUser authenticationUser = entityManager.find(AuthenticationUser.class, id);
      User user = new User();
      user.setId(authenticationUser.getId());
      user.setName(authenticationUser.getName());
      user.setLastName(authenticationUser.getLastName());
      return Optional.of(user);
    } catch (Exception exception) {
      throw new NotFoundException(exception.getMessage());
    }
  }

  @Override
  public User save(User user) {
    try {
      AuthenticationUser authenticationUser = new AuthenticationUser();
      authenticationUser.setName(user.getName());
      authenticationUser.setLastName(user.getLastName());
      entityManager.persist(authenticationUser);
      user.setId(authenticationUser.getId());
      return user;
    } catch (Exception exception) {
      throw new NotFoundException(exception.getMessage());
    }
  }

  @Override
  public List<User> findAll() {
    List<AuthenticationUser> users = entityManager.createQuery("SELECT * FROM authentication_user", AuthenticationUser.class).getResultList();
    return users.parallelStream()
      .map(authUser -> {
        User user = new User();
        user.setId(authUser.getId());
        user.setName(authUser.getName());
        user.setLastName(authUser.getLastName());
        return user;
      }).collect(Collectors.toList());
  }
}
