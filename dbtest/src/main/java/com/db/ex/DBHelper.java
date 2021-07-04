package com.db.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	public static Connection dbConn;

	public static Connection getConnection() {
		Connection connect = null;

		try {
			String user = "ora_user";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String driver = "oracle.jdbc.driver.OracleDriver";

			Class.forName(driver);
			System.out.println("DB Driver Loading");
			connect = DriverManager.getConnection(url, user, pw);
			System.out.println("DB Connection : " + connect);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 : "+cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : "+sqle.toString());
		} catch (Exception e) {
			System.out.println("Unknown error");
			e.printStackTrace();
		}

		return connect;

	}
	
}
