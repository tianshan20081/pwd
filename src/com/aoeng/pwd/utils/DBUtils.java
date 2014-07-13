package com.aoeng.pwd.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static String url = "jdbc:mysql://127.0.0.1:3306/db_pwd";
	private static String user = "root";
	private static String password = "root";
	private String driverName = "com.mysql.jdbc.Driver";

	public static Connection getConn() {
		Connection conn = null;
		try {
			// DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
