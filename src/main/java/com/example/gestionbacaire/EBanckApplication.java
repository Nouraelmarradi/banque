package com.example.gestionbacaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EBanckApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBanckApplication.class, args);
}
}
