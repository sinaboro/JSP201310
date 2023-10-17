package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;


@WebServlet("/memberUpdate.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		MemberDAO  mDao = MemberDAO.getInstance();
		MemberVO vo = mDao.getMember(userid);
		request.setAttribute("mVo", vo);
		
		RequestDispatcher dis = request.getRequestDispatcher("member/update.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		//update.jsp 입력한 회원정보를 vo클래스 저장
		MemberVO vo = new MemberVO();
		
		vo.setName(request.getParameter("name"));	
		vo.setUserid(request.getParameter("userid"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setPhone(request.getParameter("phone"));
		vo.setEmail(request.getParameter("email"));
		vo.setAdmin( Integer.parseInt(request.getParameter("admin") ));
		
		//DB연결(회원정보 전달)
		MemberDAO mDao =  MemberDAO.getInstance();
		int result = mDao.updateMember(vo);
		
		if(result== 1) {
			request.setAttribute("message", "회원수정 성공했습니다.");
		}else {
			request.setAttribute("message", "회원수정 실패했습니다.");
		}
		
//		RequestDispatcher dis = request.getRequestDispatcher("member/login.jsp");
//		dis.forward(request, response);
		response.sendRedirect("login.do");
	}

}










