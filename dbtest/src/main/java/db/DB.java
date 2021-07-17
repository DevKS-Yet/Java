package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {
	
	public DB(){}
	
	Connection conn = null;
	PreparedStatement pstmt = null;

	private Connection connectDB(String user, String pw) {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String driver = "oracle.jdbc.driver.OracleDriver";

			Class.forName(driver);
			System.out.println("DB Driver Loading");
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("DB Connection : " + conn);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 : "+cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : "+sqle.toString());
		} catch (Exception e) {
			System.out.println("Unknown error");
			e.printStackTrace();
		}
		return conn;
	}
	
	public boolean createDB(String user, String pw) {
		boolean result = false;
		try {
			conn = connectDB(user, pw);
			System.out.println("DB 연결 성공");
			String sql = "create table student(stuNo number(3) primary key, name varchar2(30) not null, kor number(3), eng number(3), math number(3), total number(3), avg number(5,2), rank number(3))";
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
			System.out.println("테이블 생성 성공");
			pstmt.close();
			sql = "create sequence stu_seq start with 1 increment by 1 minvalue 1 maxvalue 999 nocache nocycle";
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
			System.out.println("시퀀스 생성 성공");
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean deleteDB(String user, String pw) {
		boolean result = false;
		try {
			conn = connectDB(user, pw);
			System.out.println("DB 연결 성공");
			String sql = "drop table student cascade constraint purge";
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
			System.out.println("테이블 삭제 성공");
			pstmt.close();
			sql = "drop sequence stu_seq";
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
			System.out.println("시퀀스 삭제 성공");
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
}
