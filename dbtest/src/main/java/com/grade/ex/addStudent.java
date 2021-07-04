package com.grade.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.ex.DBHelper;

@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
		System.out.println("doPost");
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");

		request.setCharacterEncoding("utf-8");

		String stuNo = request.getParameter("stuNo");
		String stuName = request.getParameter("stuName");
		int stuKor = Integer.parseInt(request.getParameter("stuKor"));
		int stuEng = Integer.parseInt(request.getParameter("stuEng"));
		int stuMath = Integer.parseInt(request.getParameter("stuMath"));
		int stuTotal = stuKor+stuEng+stuMath;
		String stuAvg = String.format("%.2f", stuTotal/3.0);

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into student(stuno, name, kor, eng, math, total, avg) values("+stuNo+",'"+stuName+"'"+","+stuKor+","+stuEng+","+stuMath+","+stuTotal+","+stuAvg+")";
			conn = DBHelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("저장되었습니다.");
			pstmt.close();
			conn.close();
		} catch (SQLException sqle) {
			System.out.println("예외 발생");
			sqle.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}
