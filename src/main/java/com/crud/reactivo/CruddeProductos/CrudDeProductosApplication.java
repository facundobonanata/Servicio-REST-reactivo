package com.crud.reactivo.CruddeProductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class CrudDeProductosApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudDeProductosApplication.class, args);
	}

}
