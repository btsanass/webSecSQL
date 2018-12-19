package eu.beersafe.websec.data.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class DB {
	
	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/beersafe?allowMultiQueries=true","beersafe","StrongPassword123&*(");  
		return conn;
	}

}