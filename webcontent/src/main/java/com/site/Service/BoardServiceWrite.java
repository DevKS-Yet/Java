package com.site.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.site.Dao.BoardDao;

public class BoardServiceWrite implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			int writeResult = 0;
			String path = "c:/upload";
			int size = 10 * 1024 * 1024;
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			String btitle = multi.getParameter("btitle");
			String bcontent = multi.getParameter("bcontent");
			String bname = multi.getParameter("bname");
			String bupload = multi.getFilesystemName("bupload");
			
			BoardDao boardDao = new BoardDao();
			writeResult = boardDao.boardInsertOne(btitle, bcontent, bname, bupload);
			request.setAttribute("writeResult", writeResult);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
