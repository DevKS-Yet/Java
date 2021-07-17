package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	
	public DAO() {} //메소드 호출을 위한 기본생성자
	
	DTO sDTO = new DTO();
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;
	
	//데이터베이스 연결**
	private Connection getConnection() throws Exception {
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		System.out.println("DB연결 메소드 성공");
		return ds.getConnection();
	}
	//데이터베이스 행 갯수
	public int countDB() {
		int countDB = 0;
		try {
			conn = getConnection();
			System.out.println("DB연결");
			String sql = "select count(*) from student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			countDB = rs.getInt(1);
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
		
		return countDB;
	}
	
	//학생추가 메소드
	public int addStudent(DTO sDTO) { //DTO 객체로 받아서 반환값은 int(0이면 실패 1이면 성공)
		int resultNum = 0;
		try {
			conn = getConnection();
			System.out.println("DB연결");
			String sql = "insert into student values(stu_seq.nextval,?,?,?,?,?,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sDTO.getName());
			pstmt.setInt(2, sDTO.getKor());
			pstmt.setInt(3, sDTO.getEng());
			pstmt.setInt(4, sDTO.getMath());
			pstmt.setInt(5, sDTO.getTotal());
			pstmt.setDouble(6, sDTO.getAvg());
			resultNum = pstmt.executeUpdate();
			System.out.println("쿼리문 실행 성공");
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
		return resultNum;
	}
//-------------------------------------------------------------------------
	
	//학생출력 메소드
	public ArrayList<DTO> printStudent(ArrayList<DTO> sDTO){ //ArrayList 제네릭스로 DTO를 준 sDTO배열을 받고 반환
		try {
			conn = getConnection();
			System.out.println("DB연결");
			String sql = "select * from student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("쿼리문 실행 성공");
			while(rs.next()) {
				int stuNo = rs.getInt("stuNo");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int math = rs.getInt("math");
				int total = rs.getInt("total");
				double avg = rs.getDouble("avg");
				int rank = rs.getInt("rank");
				sDTO.add(new DTO(stuNo, name, kor, eng, math, total, avg, rank));
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
		return sDTO;
	}
//-------------------------------------------------------------------------
	
	//학생검색 메소드
	//학생검색(학번)
	public DTO searchStudentByStuNo(int stuNo) { //검색하고자하는 stuNo 매개변수를 받아서 찾은 후에 DTO로 리턴
		try {
			conn = getConnection();
			System.out.println("DB연결");
			String sql = "select * from student where stuNo=?";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setInt(1, stuNo);
			rs = pstmt.executeQuery();
			System.out.println("쿼리문 실행 성공");
			if(rs.last()) {
				if(rs.getRow()==1) {
					rs.first();
					System.out.println(rs.getRow());
					sDTO.setStuNo(rs.getInt("stuNo"));
					sDTO.setName(rs.getString("name"));
					sDTO.setKor(rs.getInt("kor"));
					sDTO.setEng(rs.getInt("eng"));
					sDTO.setMath(rs.getInt("math"));
					sDTO.setTotal(rs.getInt("total"));
					sDTO.setAvg(rs.getDouble("avg"));
					sDTO.setRank(rs.getInt("rank"));
				} else {
					rs.beforeFirst();
					String name = "";
					while(rs.next()) {
						if(rs.getRow()==1) name = rs.getString("name");
						else name += ", " + rs.getString("name");
					}
					sDTO.setName(name);
				}
			} else {
				System.out.println("데이터가 없습니다.");
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
		return sDTO;
	}
	//학생검색(이름)
	public DTO searchStudentByName(String name) {
		try {
			conn = getConnection();
			System.out.println("DB연결");
			String sql = "select * from student where name=?";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); //rs의 커서 움직이기 위함
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			System.out.println("쿼리문 실행 성공");
			if(rs.last()) { //rs 커서를 마지막 레코드로 보냄. rs값이 없을 경우엔 false
				if(rs.getRow()==1) { //현재 커서가 위치하고 있는 레코드 번호가 1인지 아닌지 확인
					rs.first();
					System.out.println(rs.getRow());
					sDTO.setStuNo(rs.getInt("stuNo"));
					sDTO.setName(rs.getString("name"));
					sDTO.setKor(rs.getInt("kor"));
					sDTO.setEng(rs.getInt("eng"));
					sDTO.setMath(rs.getInt("math"));
					sDTO.setTotal(rs.getInt("total"));
					sDTO.setAvg(rs.getDouble("avg"));
					sDTO.setRank(rs.getInt("rank"));
				} else { //위 조건이 아닐 경우 커서를 0번으로 보내며 하나씩 추가하며 이름 저장 후 출력
					rs.beforeFirst();
					name = "";
					while(rs.next()) {
						if(rs.getRow()==1) name = rs.getString("name");
						else name += ", " + rs.getString("name");
					}
					sDTO.setName(name);
				}
			} else {
				System.out.println("데이터가 없습니다.");
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
		return sDTO;
	}
	//학생검색(학번,이름)
	public DTO searchStudentByBoth(int stuNo, String name) {
		try {
			conn = getConnection();
			System.out.println("DB연결");
			String sql = "select * from student where stuNo=? and name=?";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setInt(1, stuNo);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			System.out.println("쿼리문 실행 성공");
			if(rs.last()) {
				if(rs.getRow()==1) {
					rs.first();
					System.out.println(rs.getRow());
					sDTO.setStuNo(rs.getInt("stuNo"));
					sDTO.setName(rs.getString("name"));
					sDTO.setKor(rs.getInt("kor"));
					sDTO.setEng(rs.getInt("eng"));
					sDTO.setMath(rs.getInt("math"));
					sDTO.setTotal(rs.getInt("total"));
					sDTO.setAvg(rs.getDouble("avg"));
					sDTO.setRank(rs.getInt("rank"));
				} else {
					rs.beforeFirst();
					name = "";
					while(rs.next()) {
						if(rs.getRow()==1) name = rs.getString("name");
						else name += ", " + rs.getString("name");
					}
					sDTO.setName(name);
				}
			} else {
				System.out.println("데이터가 없습니다.");
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
		return sDTO;
	}
//-------------------------------------------------------------------------
	
	//학생수정
	public void updateStudent() {
		
	}
//-------------------------------------------------------------------------
	
	//등수처리
	public boolean rankStudent() {
		boolean check = false;
		try {
			conn = getConnection();
			System.out.println("DB 연결 성공");
			String sql = "select * from student order by total desc, stuNo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("쿼리문 실행 성공");
			sql = "update student set rank=? where stuNo=?";
			pstmt2 = conn.prepareStatement(sql);
			int i=0;
			while(rs.next()) {
				pstmt2.setInt(1, ++i);
				pstmt2.setInt(2, rs.getInt("stuNo"));
				pstmt2.addBatch();
			}
			pstmt2.executeBatch();
			System.out.println("등수처리 성공");
			pstmt2.close();
			check = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt2 != null) pstmt2.close();
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
//-------------------------------------------------------------------------

}
