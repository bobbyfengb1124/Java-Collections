package test.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\bobbyfeng\\Downloads\\music\\music.db");
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Something went wrong: " + e.getMessage());
		}

	}

}
