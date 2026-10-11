package com.neeraj.sqlStoredProces;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class TestProcedureInOut {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localHost:3306/mydb1", "root", "root");

		CallableStatement call = conn.prepareCall("{CALL empInOut(?)}");

		call.setInt(1, 4);

		call.registerOutParameter(1, Types.INTEGER);

		call.execute();

		System.out.println(call.getInt(1));
	}

}
