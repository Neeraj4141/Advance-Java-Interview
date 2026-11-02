package com.neeraj.junit.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserModel {

	public static Integer nextPk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project04", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select max(id) from st_user");

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			pk = rs.getInt(1);
		}

		rs.close();
		ps.close();
		conn.close();

		return pk + 1;
	}

	public static UserBean findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project04", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from st_user where id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		if (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt("id"));
			bean.setFirst_name(rs.getString("first_name"));
			bean.setLogin(rs.getString("login"));
			System.out.println(id);
		}

		rs.close();
		ps.close();
		conn.close();

		return bean;
	}

	public static UserBean findByLogin(String login) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project04", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from st_user where login = ?");

		ps.setString(1, login);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		if (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt("id"));
			bean.setFirst_name((rs.getString("first_name")));
			bean.setLogin(rs.getString("login"));
		}

		rs.close();
		ps.close();
		conn.close();

		return bean;
	}

	public static void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project04", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into st_user (id, first_name, login) values (?, ?, ?)");

		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getFirst_name());
		ps.setString(3, bean.getLogin());

		int i = ps.executeUpdate();

		System.out.println("Data Inserted: " + i);

		ps.close();
		conn.close();
	}

	public static void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project04", "root", "root");

		PreparedStatement ps = conn.prepareStatement("update st_user set first_name = ?, login = ? where id = ?");

		ps.setString(1, bean.getFirst_name());
		ps.setString(2, bean.getLogin());
		ps.setInt(3, bean.getId());

		int i = ps.executeUpdate();

		System.out.println("Data Updated: " + i);

		ps.close();
		conn.close();
	}

	public static void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project04", "root", "root");

		PreparedStatement ps = conn.prepareStatement("delete from st_user where id = ?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();

		System.out.println("Data Deleted: " + i);

		ps.close();
		conn.close();
	}
}