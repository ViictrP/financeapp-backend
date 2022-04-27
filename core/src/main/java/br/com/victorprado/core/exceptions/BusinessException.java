package br.com.victorprado.core.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BusinessException extends RuntimeException {
  private final String message;

  protected BusinessException(String message) {
    super(message);
    this.message = message;
  }
}
