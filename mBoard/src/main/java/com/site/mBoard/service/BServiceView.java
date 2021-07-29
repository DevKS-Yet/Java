package com.site.mBoard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.mBoard.dao.BoardDao;
import com.site.mBoard.vo.BoardVo;

public class BServiceView implements PService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BServiceView - 시작");
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao boardDao = new BoardDao();
		System.out.println("BServiceView - boardOneSelect()");
		BoardVo boardVo = boardDao.boardOneSelect(bid);
		request.setAttribute("boardVo", boardVo);

		System.out.println("BServiceView - 끝");
	}

}
