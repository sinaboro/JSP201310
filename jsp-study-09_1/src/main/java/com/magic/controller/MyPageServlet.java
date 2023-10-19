package com.magic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

@WebServlet("/mypage.do")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		EmployeesDAO  mDao = EmployeesDAO.getInstance();
		EmployeesVO vo = mDao.getMember(id);
		request.setAttribute("mVo", vo);
		
		if(vo.getLev() == "A") {
			request.setAttribute("result", "3");
		}else if(vo.getLev() == "B") {
			request.setAttribute("result", "2");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("employees/mypage.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
