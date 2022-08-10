package com.example.service;

import java.util.List;

public interface SchemaFacadeService {
	List<String> getTables(String jdbcUrl,String username,String password);
}
