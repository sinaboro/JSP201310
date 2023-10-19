package com.magic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("employees/login.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String url = "employees/login.jsp";
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		
		System.out.println();
		int result = eDao.userCheck(id, pass);
		
		if(result ==1) {
			EmployeesVO vo = eDao.getMember(id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo);
			request.setAttribute("message", "회원가입에 성공했습니다.");
			url = "employees/main.jsp";
		}else if(result == 0) {
			request.setAttribute("message", "비빌번호가 틀립니다.");
		}else if(result == -1) {
			request.setAttribute("message", "아이디가 존재하지 않습니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
