package com.neeraj.sqlStoredProces;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestProcuderIn {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localHost:3306/mydb1", "root", "root");

		CallableStatement call = conn.prepareCall("CALL empIn(?)");

		call.setInt(1, 1);
		call.execute();
		ResultSet rs = call.getResultSet();

		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));

		}

	}

}
