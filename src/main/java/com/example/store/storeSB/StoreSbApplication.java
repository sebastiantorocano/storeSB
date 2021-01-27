package com.example.store.storeSB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class StoreSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreSbApplication.class, args);
		System.out.print("preuba");
	}

}
