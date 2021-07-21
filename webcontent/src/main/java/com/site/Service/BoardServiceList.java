package com.site.Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.Dao.BoardDao;
import com.site.Vo.BoardVo;

public class BoardServiceList implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDao boardDao = new BoardDao();
		ArrayList<BoardVo> list = boardDao.boardSelectAll();
		request.setAttribute("list", list);

	}

}
