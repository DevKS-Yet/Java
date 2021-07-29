package com.site.mBoard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.mBoard.dao.BoardDao;

public class BServiceDelete implements PService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BServiceDelete - 시작");
		
		BoardDao boardDao = new BoardDao();
		int bid = Integer.parseInt(request.getParameter("bid"));
		System.out.println("BServiceDelete - boardOneDelete()");
		int result = boardDao.boardOneDelete(bid);
		request.setAttribute("resultDelete", result);

		System.out.println("BServiceDelete - 끝");
	}

}
