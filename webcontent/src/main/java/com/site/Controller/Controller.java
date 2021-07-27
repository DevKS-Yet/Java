package com.site.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.Service.BoardService;
import com.site.Service.BoardServiceContent_view;
import com.site.Service.BoardServiceDelete;
import com.site.Service.BoardServiceList;
import com.site.Service.BoardServiceModify;
import com.site.Service.BoardServiceWrite;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		
		request.setCharacterEncoding("utf-8");
		RequestDispatcher dp = null; // DAO 실행 후 request 정보 보내기 위함
		
		String uri = request.getRequestURI(); // 도메인 경로 x / filePath O
		String path = uri.substring(request.getContextPath().length()); // 경로중 프로젝트명만 뺀 문자열
		System.out.println(path);
		
		if(path.equals("/list.do")) { // 해당 경로로 들어왔을 경우
			System.out.println("Controller - /list.do");
			//Interface BoardService와 Class BoardServiceList(interface 상속) 생성
			BoardService boardService = new BoardServiceList(); // Interface를 사용한 다형성
			System.out.println("Controller - BoardServiceList 객체 생성 완료");
			//Class BoardServiceList에서 execute 메소드 내부 작성
			boardService.execute(request, response); // BoardServiceList에 있는 execute 실행 및 반환값 있을 시 request에 저장하여 받음
			System.out.println("Controller - execute 메소드 실행 완료");
			dp = request.getRequestDispatcher("/board/list.jsp"); // 절대경로, 상대경로 지정 가능. 유지보수 편리한 걸로
			System.out.println("Controller - dp 위치 선정 완료");
			
		} else if(path.equals("/content_view.do")) {
			System.out.println("Controller - /content_view.do");
			BoardService boardService = new BoardServiceContent_view();
			System.out.println("Controller - BoardServiceContent_view 객체 생성 완료");
			boardService.execute(request, response);
			System.out.println("Controller - execute 메소드 실행 완료");
			dp = request.getRequestDispatcher("./content_view.jsp");
			System.out.println("Controller - dp 위치 선정 완료");
			
		} else if(path.equals("/board/write.do")) {
			System.out.println("Controller - /board/write.do");
			BoardService boardService = new BoardServiceWrite();
			System.out.println("Controller - BoardServiceWrite 객체 생성 완료");
			boardService.execute(request, response);
			dp = request.getRequestDispatcher("/board/list.do"); // /board/list.do를 실행 시켜서 리스트로 돌아가기
			System.out.println("Controller - dp 위치 선정 완료");
			
		} else if(path.equals("/board/modify_view.do")) {
			System.out.println("Controller - /board/modify_view.do");
			BoardService boardService = new BoardServiceContent_view();
			System.out.println("Controller - boardService 객체 생성 완료");
			boardService.execute(request, response);
			System.out.println("Controller - execute 메소드 실행 완료");
			dp = request.getRequestDispatcher("./modify_view.jsp");
			System.out.println("Controller - dp 위치 선정 완료");
			
		} else if(path.equals("/board/modify.do")) {
			System.out.println("Controller - /board/modify.do");
			BoardService boardService = new BoardServiceModify();
			System.out.println("Controller - boardService 객체 생성 완료");
			boardService.execute(request, response);
			System.out.println("Controller - execute 메소드 실행 완료");
			dp = request.getRequestDispatcher("/board/content_view.do");
			System.out.println("Controller - dp 위치 선정 완료");
			
		} else if(path.equals("/board/delete.do")) {
			System.out.println("Controller - /board/delete.do");
			BoardService boardService = new BoardServiceDelete();
			System.out.println("Controller - boardService 객체 생성 완료");
			boardService.execute(request, response);
			System.out.println("Controller - execute 메소드 실행 완료");
			dp = request.getRequestDispatcher("/board/list.do");
			System.out.println("Controller - dp 위치 선정 완료");
		}
		
		dp.forward(request, response);
		
	}

}
