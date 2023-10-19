package com.spgcrud.druc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DrucApplication{

	public static void main(String[] args) {
		SpringApplication.run(DrucApplication.class, args);
		System.out.println("hi world");
	}

//@Bean
//	public ModelMapper modelMapper() {
//		return new ModelMapper();
//	}

}
