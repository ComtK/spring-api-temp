package com.comtk.jejueater;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@MapperScan(value = {"com.comtk.jejueater.mapper"})
@EnableJpaRepositories(basePackages = "com.comtk.jejueater.repository")
public class JejueaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JejueaterApplication.class, args);
	}
}
