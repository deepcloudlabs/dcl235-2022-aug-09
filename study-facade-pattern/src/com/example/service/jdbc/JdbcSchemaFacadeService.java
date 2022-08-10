package com.example.service.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.service.SchemaFacadeService;

public class JdbcSchemaFacadeService implements SchemaFacadeService {

	@Override
	public List<String> getTables(String jdbcUrl, String username, String password) {
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			System.err.println(connection.getClass());
			DatabaseMetaData metaData = connection.getMetaData();
			System.err.println(metaData.getClass());
			List<String> tableNames = new ArrayList<>();
			ResultSet rs = metaData.getTables(null, null, null, null);
			System.err.println(rs.getClass());
			while (rs.next()) {
				tableNames.add(rs.getString("TABLE_NAME"));
			}
			return tableNames;
		} catch (SQLException e) {
			System.err.println("Error: "+e.getMessage());
			return List.of();
		}
	}

}
