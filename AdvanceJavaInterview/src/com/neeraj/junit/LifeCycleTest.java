package com.neeraj.junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LifeCycleTest {

	private static Connection conn = null;
	private PreparedStatement pstmt = null;

	@BeforeClass
	public static void beforeClass() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project04", "root", "root");

		System.out.println("DataBase Connected");
	}

	@Before
	public void before() throws SQLException {
		System.out.println("Before Test");
		conn.setAutoCommit(false);

	}

	@Test
	public void testAddUser() throws SQLException {
		System.out.println("Test User Add Method");

		pstmt = conn.prepareStatement("Insert Into st_user(id, first_name, login) VALUES (?,?,?)");

		pstmt.setInt(1, 10);
		pstmt.setString(2, "Neeraj");
		pstmt.setString(3, "n@gmail.com");

		int row = pstmt.executeUpdate();

		System.out.println("Row Inserted = " + row);
	}

	@After
	public void afterTest() throws SQLException {
		System.out.println("After Test");
		if (conn != null && !conn.isClosed()) {
			conn.commit();
		}

	}

	@AfterClass
	public static void afterClass() throws SQLException {
		System.out.println("After Class");
		if (conn != null) {
			conn.close();
			System.out.println("Database Connection is Closed");
		}
	}

}
