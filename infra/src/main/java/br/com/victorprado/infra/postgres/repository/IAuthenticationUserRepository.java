package br.com.victorprado.infra.postgres.repository;

import br.com.victorprado.infra.model.AuthenticationUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationUserRepository extends PagingAndSortingRepository<AuthenticationUser, Long> {

}
