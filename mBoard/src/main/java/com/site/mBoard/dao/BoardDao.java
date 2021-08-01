package com.site.mBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.site.mBoard.vo.BoardVo;

public class BoardDao {
	
	private DataSource ds = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private ArrayList<BoardVo> list = null;
	private BoardVo boardVo = null;
	private int result = 0;
	
	private Connection getConnection() throws Exception {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		return ds.getConnection();
	}

//게시글 개수----------------------------------------------------------
	public int boardCountSelect(String category, String searchWord) {
		System.out.println("BoardDao - 시작");
		int listCount = 0;
		try {
			conn = getConnection();
			String sql = "";
			
			switch(category) {
			case "":
				sql = "select count(*) c from board";
				pstmt = conn.prepareStatement(sql);
				break;
				
			case "all":
				sql = "select count(*) c from board where btitle like ? or bcontent like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+searchWord+"%");
				pstmt.setString(2, "%"+searchWord+"%");
				break;
				
			default:
				sql = "select count(*) c from board where "+category+" like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+searchWord+"%");
				break;
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt("c");
			}
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
		System.out.println("BoardDao - 끝");
		return listCount;
	}
	
//게시글 리스트-----------------------------------------------------------
	public ArrayList<BoardVo> boardAllSelect(int startRow, int endRow, String category, String searchWord){
		System.out.println("BoardDao - 시작");
		list = new ArrayList<BoardVo>();
		try {
			conn = getConnection();
			String sql = "";
			
			switch(category) {
			case "":
				sql = "select * from (select rownum as rnum, b.* from (select * from board order by bgroup desc, bstep asc) b) where rnum>=? and rnum<=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				break;
				
			case "all":
				sql = "select * from (select rownum as rnum, b.* from (select * from board where btitle like ? or bcontent like ? order by bgroup desc, bstep asc) b) where rnum>=? and rnum<=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+searchWord+"%");
				pstmt.setString(2, "%"+searchWord+"%");
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				break;
				
			default:
				sql = "select * from (select rownum as rnum, b.* from (select * from board where "+category+" like ? order by bgroup desc, bstep asc) b) where rnum>=? and rnum<=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+searchWord+"%");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				break;
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BoardVo(rs.getInt("bid"), rs.getString("btitle"), rs.getString("bcontent"), rs.getString("bname"), rs.getInt("bgroup"), rs.getInt("bstep"), rs.getInt("bindent"), rs.getTimestamp("bdate"), rs.getString("bupload"), rs.getInt("bhit")));
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
		System.out.println("BoardDao - 끝");
		return list;
	}
	
//글보기-------------------------------------------------------------
	public BoardVo boardOneSelect(int bid) {
		System.out.println("BoardDao - 시작");
		try {
			conn = getConnection();
			String sql = "select * from board where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardVo = new BoardVo(rs.getInt("bid"), rs.getString("btitle"), rs.getString("bcontent"), rs.getString("bname"), rs.getInt("bgroup"), rs.getInt("bstep"), rs.getInt("bindent"), rs.getTimestamp("bdate"), rs.getString("bupload"), rs.getInt("bhit"));
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
		System.out.println("BoardDao - 끝");
		return boardVo;
	}
	
//글작성-----------------------------------------------------------
	public int boardOneInsert(String btitle, String bcontent, String bname, String bupload) {
		System.out.println("BoardDao - 시작");
		try {
			conn = getConnection();
			String sql = "insert into board values(board_seq.nextval, ?, ?, ?, board_seq.currval, 0, 0, sysdate, ?, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);
			pstmt.setString(3, bname);
			pstmt.setString(4, bupload);
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
		System.out.println("BoardDao - 끝");
		return result;
	}
	
//글수정-----------------------------------------------------------
	public int boardOneUpdate(int bid, String btitle, String bcontent, String bname, String bupload) {
		System.out.println("BoardDao - 시작");
		try {
			conn = getConnection();
			String sql = "update board set btitle = ?, bcontent = ?, bname = ?, bupload = ? where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);
			pstmt.setString(3, bname);
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
		System.out.println("BoardDao - 끝");
		return result;
	}
	
//글답변-----------------------------------------------------------
	public int boardOneReply(String btitle, String bcontent, String bname, int bgroup, int bstep, int bindent, String bupload) {
		System.out.println("BoardDao - 시작");
		System.out.println("BoardDao - boardStepAdd()");
		boardStepAdd(bgroup, bstep); //하위 게시물 step 1 증가 메소드
		try {
			conn = getConnection();
			String sql = "insert into board values(board_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate, ?, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);
			pstmt.setString(3, bname);
			pstmt.setInt(4, bgroup);
			pstmt.setInt(5, bstep+1);
			pstmt.setInt(6, bindent+1);
			pstmt.setString(7, bupload);
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
		System.out.println("BoardDao - 끝");
		return result;
	}
	
	//하위 게시물 step 1추가
	public void boardStepAdd(int bgroup, int bstep) {
		System.out.println("BoardDao - 시작");
		try {
			conn = getConnection();
			String sql = "update board set bstep = bstep+1 where bgroup=? and bstep>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();
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
		System.out.println("BoardDao - 끝");
	}
	
//글삭제-----------------------------------------------------------
	public int boardOneDelete(int bid) {
		System.out.println("BoardDao - 시작");
		try {
			conn = getConnection();
			String sql = "delete from board where bid = ?";
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
		System.out.println("BoardDao - 끝");
		return result;
	}

}
