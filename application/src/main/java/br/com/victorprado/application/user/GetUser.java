package br.com.victorprado.application.user;

import br.com.victorprado.core.repository.UserRepository;
import br.com.victorprado.core.usercase.user.IGetUserUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class GetUser implements IGetUserUseCase {

  private final UserRepository repository;
}
