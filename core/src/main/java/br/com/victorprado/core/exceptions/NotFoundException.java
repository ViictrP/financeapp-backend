package br.com.victorprado.core.exceptions;

public class NotFoundException extends BusinessException {

  public NotFoundException(String message) {
    super(message);
  }

  public String getMessage() {
    return super.getMessage();
  }
}
