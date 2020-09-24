package com.gem.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/*
 * 工具类里面的方法建议静态，可以直接调用，无需实例化对象。
 * */
public class JDBCUtil {
	private static Properties properties;
	static {
		properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream("db.properties");
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//获得连接
	public static Connection getConnection() {
		//加载驱动
		try {
			Class.forName((String) properties.get("driver"));
			String url = (String) properties.get("url");
			String user = (String) properties.get("username");
			String password = (String) properties.get("password");
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//关闭资源
	public static void close(Connection connection, Statement statement, ResultSet set) {
		if (set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//statement的关闭
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//conncetion的关闭
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
