package com.site.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.Dao.BoardDao;

public class BoardServiceDelete implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int deleteResult = 0;
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao boardDao = new BoardDao();
		deleteResult = boardDao.boardDeleteOne(bid);
		request.setAttribute("deleteResult", deleteResult);

	}

}
