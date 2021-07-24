package com.site.Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.Dao.BoardDao;
import com.site.Vo.BoardVo;

public class BoardServiceList implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDao boardDao = new BoardDao(); //Class BoardDao 생성 및 메소드 호출을 위한 BoardDao 객체 생성
		System.out.println("Service - BoardDao 객체 생성 완료");
		ArrayList<BoardVo> list = boardDao.boardSelectAll(); //Class BoardDao에서 생성한 메소드 호출 및 반환값 받기
		System.out.println("Service - BoardDao 메소드 실행 완료");
		request.setAttribute("list", list); // 받은 반환값 request에 지정하여 execute 메소드 호출 시킨 컨트롤러로 이동
		System.out.println("Service - setAttribute 완료");

	}

}
