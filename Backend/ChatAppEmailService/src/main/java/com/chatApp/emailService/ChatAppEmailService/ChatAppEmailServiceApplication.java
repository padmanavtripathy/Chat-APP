package com.chatApp.emailService.ChatAppEmailService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ChatAppEmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatAppEmailServiceApplication.class, args);
	}

}
