package com.site.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.site.Vo.BoardVo;

public class BoardDao {
	
	private DataSource ds = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws Exception {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		return ds.getConnection();
	}
	
	public ArrayList<BoardVo> boardSelectAll(){ // db에서 모든 레코드를 rs -> arraylist로 변환
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		try {
			conn = getConnection(); // DB 연결
			String sql = "select * from board order by bid desc"; // 내림차순으로 모든 레코드 뽑기
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) { // 각각 rs에 있는 값을 list에 저장
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bname = rs.getString("bname");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				Timestamp bdate = rs.getTimestamp("bdate");
				String bupload = rs.getString("bupload");
				int bhit = rs.getInt("bhit");
				list.add(new BoardVo(bid, btitle, bname, bcontent, bgroup, bstep, bindent, bdate, bupload, bhit));
//				list.add(new BoardVo(rs.getInt("bid"), rs.getString("btitle"), rs.getString("bcontent"), rs.getString("bname"), rs.getInt("bgroup"), rs.getInt("bstep"), rs.getInt("bindent"), rs.getTimestamp("bdate"), rs.getString("bupload"), rs.getInt("bhit")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public BoardVo boardSelectOne(int bid) {
		BoardVo boardVo = new BoardVo();
		try {
			conn = getConnection();
			String sql = "select * from board where bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardVo.setBid(rs.getInt("bid"));
				boardVo.setBtitle(rs.getString("btitle"));
				boardVo.setBcontent(rs.getString("bcontent"));
				boardVo.setBname(rs.getString("bname"));
				boardVo.setBgroup(rs.getInt("bgroup"));
				boardVo.setBstep(rs.getInt("bstep"));
				boardVo.setBindent(rs.getInt("bindent"));
				boardVo.setBdate(rs.getTimestamp("bdate"));
				boardVo.setBupload(rs.getString("bupload"));
				boardVo.setBhit(rs.getInt("bhit"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return boardVo;
	}
	
	public int boardInsertOne(String btitle, String bcontent, String bname, String file) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "insert into board values(board_seq.nextval, ?, ?, ?, board_seq.currval, 0, 0, sysdate, ?, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);
			pstmt.setString(3, bname);
			pstmt.setString(4, file);
			result = pstmt.executeUpdate();
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
	
	public int boardUpdateOne(int bid, String btitle, String bname, String bcontent, String bupload) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "update board set btitle=?, bname=?, bcontent=?, bupload=? where bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bname);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bupload);
			pstmt.setInt(5, bid);
			result = pstmt.executeUpdate();
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
	
	public int boardDeleteOne(int bid) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "delete from board where bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			result = pstmt.executeUpdate();
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
