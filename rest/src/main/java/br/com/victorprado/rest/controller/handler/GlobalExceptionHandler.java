package br.com.victorprado.rest.controller.handler;

import br.com.victorprado.core.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<Object> handleNotFoundException(NotFoundException exception) {
    log.info("Not found exception was cought. Error: {}. Returning status code 404", exception.getMessage());
    return ResponseEntity.notFound().build();
  }
}
