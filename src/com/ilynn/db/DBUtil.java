package com.ilynn.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ilynn.utils.Constant;
import com.ilynn.utils.TokenUtils;

public class DBUtil {
	private Connection conn;
	// 指定连接的数据库url
	private String url = "jdbc:mysql://127.0.0.1:3306/" + Constant.DB_NAME;
	// 指定连接的数据库的用户名
	private String user = "root";
	// 指定连接的数据库密码
	private String password = "123456";

	private Statement statement;
	private ResultSet resultSet;

	/**
	 * 打开数据库连接
	 */
	public boolean openConnect() {
		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
				// 连接成功的提示信息
				System.out.println("数据库连接成功");
				return true;
			}
		} catch (Exception e) {
			System.out.println("数据库连接失败:" + e.getMessage());

		}
		return false;
	}

	/**
	 * 获取查询user表后的数据
	 * 
	 * @return
	 */
	public ResultSet getUser() {
		// 创建statement对象
		try {
			statement = conn.createStatement();
			// 执行SQL查询语句
			resultSet = statement.executeQuery("select * from " + Constant.TABLE_NAME);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	public ResultSet getUserInfo() {
		// 创建 statement对象
		try {
			statement = conn.createStatement();
			// 执行SQL查询语句
			resultSet = statement.executeQuery("select * from " + Constant.TABLE_NAME);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	/**
	 * 判断数据库中是否存在这个用户,及判断密码是否正确
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean isExistInDB(String name, String password) {

		// 创建statement对象
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from " + Constant.TABLE_NAME);
			if (resultSet != null) {
				while (resultSet.next()) {
					if (resultSet.getString("user_name").equals(name)) {
						System.out.println("用户存在");
						return true;
					}

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库查询出错:" + e.getMessage());
		}
		return false;
	}

	// 判断数据库中是否存在某个用户名,注册的时候判断
	public boolean isExistInDB(String username) {
		boolean isFlag = false;
		// 创建 statement对象
		try {
			statement = conn.createStatement();
			// 执行SQL查询语句
			resultSet = statement.executeQuery("select * from " + Constant.TABLE_NAME);
			if (resultSet != null) {
				while (resultSet.next()) {
					if (resultSet.getString("user_name").equals(username)) {
						isFlag = true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			isFlag = false;
		}
		return isFlag;
	}

	/**
	 * 注册 将用户名和密码插入数据库
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean insertDataToDB(String username, String password) {
		String sql = " insert into " + Constant.TABLE_NAME + " ( user_id, user_name , user_pwd ) values ( " + 108
				+ ", '" + username + "', " + "'" + password + "' )";

		try {
			statement = conn.createStatement();
			return statement.execute(sql);
		} catch (SQLException e) {
			System.out.println("注册失败:" + e.getMessage());
		}
		return false;
	}

	/**
	 * 注册 将用户名和密码插入数据库
	 * 
	 * @param username
	 * @param password
	 * @param userhead
	 * @return
	 */
	public boolean insertDataToDB(String username, String password, String userhead) {
		String token = TokenUtils.getToken(username, password);
		System.out.println("path------->" + userhead);
		String imagePath = Constant.BASE_URL + "images/" + userhead;
		try {
			statement = conn.createStatement();
			String sql = " insert into " + Constant.TABLE_NAME
					+ " ( user_name , user_pwd , token , user_head ) values ( " + "'" + username + "', " + "'"
					+ password + "', " + "'" + token + "', " + "'" + imagePath + "' )";
			return statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void closeConnect() {

		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (conn != null) {
				conn.close();
			}

			System.out.println("关闭数据库连接");
		} catch (SQLException e) {
			System.out.println("关闭数据库连接失败:" + e.getMessage());
		}
	}
}
