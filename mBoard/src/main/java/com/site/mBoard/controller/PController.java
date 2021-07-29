package com.site.mBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.mBoard.service.BServiceDelete;
import com.site.mBoard.service.BServiceList;
import com.site.mBoard.service.BServiceModify;
import com.site.mBoard.service.BServiceReply;
import com.site.mBoard.service.BServiceView;
import com.site.mBoard.service.BServiceWrite;
import com.site.mBoard.service.MServiceLogin;
import com.site.mBoard.service.PService;

@WebServlet("*.do")
public class PController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller - 시작");
		
		request.setCharacterEncoding("utf-8");
		
		RequestDispatcher rd = null; //디스패처 선언
		PService pService = null; // 다형성용 서비스 인터페이스 선언
		
		String uri = request.getRequestURI();
		String path = uri.substring(request.getContextPath().length());
		System.out.println("들어온 경로 - "+path); // 경로 확인용
		
		switch(path) {
		case "/member/login.do": // 로그인
			pService = new MServiceLogin();
			System.out.println("Controller - execute()");
			pService.execute(request, response);
			System.out.println("Controller - ./loginCheck.jsp");
			response.sendRedirect("./loginCheck.jsp");
			break;
		
		case "/board/blist.do": // 리스트
			pService = new BServiceList();
			System.out.println("Controller - execute()");
			pService.execute(request, response);
			System.out.println("Controller - /board/blist.jsp");
			rd = request.getRequestDispatcher("/board/blist.jsp");
			break;
			
		case "/board/bview.do": // 글보기
			pService = new BServiceView();
			System.out.println("Controller - execute()");
			pService.execute(request, response);
			System.out.println("Controller - /board/bview.jsp");
			rd = request.getRequestDispatcher("/board/bview.jsp");
			break;
			
		case "/board/bwrite.do": // 글작성
			pService = new BServiceWrite();
			System.out.println("Controller - execute()");
			pService.execute(request, response);
			System.out.println("Controller - /board/blist.do");
			rd = request.getRequestDispatcher("/board/blist.do");
			break;
			
		case "/board/bmodifyview.do": // 글수정 페이지로 이동
			pService = new BServiceView();
			System.out.println("Controller - execute()");
			pService.execute(request, response);
			System.out.println("Controller - /board/bmodify.jsp");
			rd = request.getRequestDispatcher("/board/bmodify.jsp");
			break;
		
		case "/board/bmodify.do": // 글수정
			pService = new BServiceModify();
			System.out.println("Controller - execute()");
			pService.execute(request, response);
			System.out.println("Controller - /board/blist.do");
			rd = request.getRequestDispatcher("/board/blist.do");
			break;
		
		case "/board/breplyview.do": // 글답변 페이지로 이동
			pService = new BServiceView();
			System.out.println("Controller - execute()");
			pService.execute(request, response);
			System.out.println("Controller - /board/breply.jsp");
			rd = request.getRequestDispatcher("/board/breply.jsp");
			break;
			
		case "/board/breply.do": // 글답변
			pService = new BServiceReply();
			System.out.println("Controller - execute()");
			pService.execute(request, response);
			System.out.println("Controller - /board/blist.do");
			rd = request.getRequestDispatcher("/board/blist.do");
			break;
			
		case "/board/bdelete.do": // 글삭제
			pService = new BServiceDelete();
			System.out.println("Controller - execute()");
			pService.execute(request, response);
			System.out.println("Controller - /board/blist.do");
			rd = request.getRequestDispatcher("/board/blist.do");
			break;
			
		}
		
		if(rd != null) rd.forward(request, response); // 이건 그냥 null에러 보기싫어서
		
		System.out.println("Controller - 끝");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
