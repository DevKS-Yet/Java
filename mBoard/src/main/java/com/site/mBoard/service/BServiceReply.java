package com.site.mBoard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.site.mBoard.dao.BoardDao;

public class BServiceReply implements PService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BServiceReply - 시작");
		
		BoardDao boardDao = new BoardDao();
		try {
			int size = 10 * 1024 * 1024;
			String path = "c:/upload";
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			String btitle = multi.getParameter("btitle");
			String bcontent = multi.getParameter("bcontent");
			String bname = multi.getParameter("bname");
			int bgroup = Integer.parseInt(multi.getParameter("bgroup"));
			int bstep = Integer.parseInt(multi.getParameter("bstep"));
			int bindent = Integer.parseInt(multi.getParameter("bindent"));
			String bupload = multi.getFilesystemName("bupload");
			System.out.println("BServiceReply - boardOneReply()");
			int result = boardDao.boardOneReply(btitle, bcontent, bname, bgroup, bstep, bindent, bupload);
			request.setAttribute("resultReply", result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("BServiceReply - 끝");
	}

}
