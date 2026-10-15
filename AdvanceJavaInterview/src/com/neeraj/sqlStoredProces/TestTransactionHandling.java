package com.neeraj.sqlStoredProces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestTransactionHandling {

	public static void main(String[] args) {
		add();
	}

	public static void add() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");

			conn.setAutoCommit(false); // Transaction start

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employee(name, salary) VALUES(?, ?)");

			pstmt.setString(1, "parth");
			pstmt.setInt(2, 50000);

			pstmt.executeUpdate();

			conn.commit(); // Changes permanently save

			System.out.println("Transaction Committed Successfully");

			pstmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("Transaction Failed");
			e.printStackTrace();
		}
	}

}
