package com.site.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.Dao.BoardDao;

public class BoardServiceModify implements BoardService {
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int modifyResult = 0;
		int bid = Integer.parseInt(request.getParameter("bid"));
		String btitle = request.getParameter("btitle");
		String bname = request.getParameter("bname");
		String bcontent = request.getParameter("bcontent");
		String bupload = request.getParameter("bupload");
		BoardDao boardDao = new BoardDao();
		modifyResult = boardDao.boardUpdateOne(bid, btitle, bname, bcontent, bupload);
		request.setAttribute("modifyResult", modifyResult);
		
	}

}
