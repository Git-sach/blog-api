package com.adriencheynet.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		try {
			String MYSQL_HOST = System.getenv("MYSQL_HOST");
			System.out.println("MYSQL_HOST : " + MYSQL_HOST);
	
			String MYSQL_USERNAME = System.getenv("MYSQL_USERNAME");
			System.out.println("MYSQL_USERNAME : " + MYSQL_USERNAME);
	
			String MYSQL_PASSWORD = System.getenv("MYSQL_PASSWORD");
			System.out.println("MYSQL_PASSWORD : " + MYSQL_PASSWORD);
	
			SpringApplication.run(BlogApplication.class, args);
		} catch (Exception e) {
			
			System.out.println("Erreur de connexion");
		}
	}

}
