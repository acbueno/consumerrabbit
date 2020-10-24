package br.com.acbueno.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerMessageRabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMessageRabbitApplication.class, args);
	}

}
