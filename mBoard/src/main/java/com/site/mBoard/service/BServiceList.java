package com.site.mBoard.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.mBoard.dao.BoardDao;
import com.site.mBoard.vo.BoardVo;

public class BServiceList implements PService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BServiceList - 시작");
		
		BoardDao boardDao = new BoardDao();
		
		String category = "";
		String searchWord = "";
		try {
			request.setCharacterEncoding("utf-8");
			if(request.getParameter("searchWord")!=null) {
				category = request.getParameter("category");
				searchWord = request.getParameter("searchWord");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("BServiceList - boardCountSelect()");
		int listCount = boardDao.boardCountSelect(category, searchWord);
		
		int page = 1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int limit = 10; // 목록에 나타날 게시글 최대 수
		int pageLimit = 10; // 하단 페이지 넘버의 최대 수
		int maxPage = (int)((double)listCount/limit+0.99); // 총게시글/목록최대수+0.99 = 총 페이지
		int startPage = (((int)((double)page/pageLimit+0.99))-1)*limit+1; // 설명 힘듬. 현재페이지가 하단페이지최대수를 넘지않았다면 1 넘는다면 넘은 배수만큼
		int endPage = startPage+pageLimit-1; // 시작페이지에서 하단페이지최대수 만큼 더한 후에 1뺌(1빼는 이유는 10개를 내보내는거지 11개를 내보내는게 아님)
		if(endPage>maxPage) endPage=maxPage; // 만약 끝페이지가 최대페이지를 넘었을 경우
		int startRow = (page-1)*limit+1; // 목록 최대 수 * 현재페이지 + 1 = 해당 시작 레코드
		int endRow = startRow+limit-1; // 시작레코드 + 목록 최대 수 -1
		
		request.setAttribute("page", page);
		request.setAttribute("limit", limit);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("category", category);
		request.setAttribute("searchWord", searchWord);
		
		
		System.out.println("BServiceList - memberAllSelect()");
		ArrayList<BoardVo> list = boardDao.boardAllSelect(startRow, endRow, category, searchWord);
		request.setAttribute("list", list);
		
		System.out.println("BServiceList - 끝");
	}

}
