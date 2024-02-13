package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	Statement statement;
	public Conn() {

		Connection connection;

		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","root");
			statement=connection.createStatement();		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
