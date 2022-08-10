package com.example.application;

import com.example.service.SchemaFacadeService;
import com.example.service.jdbc.JdbcSchemaFacadeService;

public class FacadeExercisApplication {

	public static void main(String[] args) {
		SchemaFacadeService facadeService = new JdbcSchemaFacadeService();
		facadeService.getTables("jdbc:mysql://localhost:3306/world?useSSL=false", 
				                 "root", "Secret_123")
		             .forEach(System.out::println);
	}

}
