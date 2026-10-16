package com.neeraj.sqlStoredProces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestTransactionHandling {

	public static void main(String[] args) throws SQLException {
		add();
	}

	public static void add() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");

			conn.setAutoCommit(false); // Transaction start

			pstmt = conn.prepareStatement("INSERT INTO employee(name, salary) VALUES(?, ?)");

			pstmt.setString(1, "parth");
			pstmt.setInt(2, 50000);

			pstmt.executeUpdate();

			conn.commit(); // Changes permanently save

			System.out.println("Transaction Committed Successfully");

		} catch (Exception e) {
			conn.rollback();
			System.out.println("Transaction Failed");
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
	}

}
