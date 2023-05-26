package com.example.withoutdb;

import com.example.withoutdb.service.DBConn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class WithoutdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(WithoutdbApplication.class, args);
	}


}
