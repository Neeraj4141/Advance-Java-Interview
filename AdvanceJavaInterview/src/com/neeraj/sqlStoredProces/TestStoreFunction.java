package com.neeraj.sqlStoredProces;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestStoreFunction {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");

		CallableStatement call = conn.prepareCall("{CALL squareProc(?, ?)}");

		call.setInt(1, 5);                         // Parameter 1: Input
		call.registerOutParameter(2, Types.INTEGER); // Parameter 2: Output

		call.execute();

		System.out.println("Square: " + call.getInt(2));

	}

}
