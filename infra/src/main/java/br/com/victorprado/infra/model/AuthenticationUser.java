package br.com.victorprado.infra.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AuthenticationUser {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  private String name;
  private String lastName;
}
