package com.site.mBoard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.site.mBoard.dao.MemberDao;

public class MServiceLogin implements PService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MServiceLogin - 시작");
		
		HttpSession session = request.getSession(); // 세션 설정용
		MemberDao memberDao = new MemberDao();
		try {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			System.out.println("MServiceLogin - memberLogin()");
			String nickname = memberDao.memberLogin(id, pw);
			if(!nickname.equals("")) { // 닉네임 값이 ""과 같지 않을 경우
				session.setAttribute("session_nickname", nickname);
				session.setAttribute("session_flag", "success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("MServiceLogin - 끝");
	}

}
