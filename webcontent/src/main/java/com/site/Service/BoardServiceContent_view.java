package com.site.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.Dao.BoardDao;
import com.site.Vo.BoardVo;

public class BoardServiceContent_view implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao boardDao = new BoardDao();
		BoardVo boardVo = boardDao.boardSelectOne(bid);
		request.setAttribute("boardVo", boardVo);

	}

}
