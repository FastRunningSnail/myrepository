package com.entor.uims.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * jdbc工具类
 * 
 * @author Administrator
 *
 */
public class DBUtil {
	private static String url;// 连接
	private static String user;// 用户名
	private static String password;// 密码

	private static Properties properties;// 属性文件对象

	private static Connection conn;// 数据库连接对象

	static {
		try {
			// 1.读取jdbc.properties
			InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			// 2.使用properties对象加载输入流
			properties = new Properties();
			properties.load(is);
			// 3.相关属性赋值
			url = properties.getProperty("jdbc.url");
			user = properties.getProperty("jdbc.user");
			password = properties.getProperty("jdbc.password");
			// 4.加载jdbc驱动
			Class.forName(properties.getProperty("jdbc.driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得连接对象
	 * 
	 * @return
	 */
	public static Connection getConn() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭相关对象，让出资源
	 * 
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		System.out.println("当前连接对象:" + getConn());
	}
}
