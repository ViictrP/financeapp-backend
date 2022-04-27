package br.com.victorprado.rest.controller;

import br.com.victorprado.core.entity.User;
import br.com.victorprado.core.exceptions.NotFoundException;
import br.com.victorprado.core.usercase.user.ICreateUserUseCase;
import br.com.victorprado.core.usercase.user.IGetUserUseCase;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

  private final IGetUserUseCase getUser;
  private final ICreateUserUseCase createUser;

  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable Long id) {
    log.info("get user by id request received {}", id);
    Optional<User> optionalResult = getUser.get(id);
    if (optionalResult.isPresent()) {
      User user = optionalResult.get();
      log.info("user found {}", user.getName());
      return ResponseEntity.ok(user);
    }
    log.info("user was not found id: {}", id);
    throw new NotFoundException("user not found");
  }
}
