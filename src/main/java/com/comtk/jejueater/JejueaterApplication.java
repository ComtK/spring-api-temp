package com.comtk.jejueater;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.comtk.jejueater.mapper"})
public class JejueaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JejueaterApplication.class, args);
	}

}
