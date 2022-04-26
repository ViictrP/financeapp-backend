package br.com.victorprado.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.victorprado.infra.model")
@ComponentScan(basePackages = "br.com.victorprado")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
