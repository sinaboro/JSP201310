package com.saeyan.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		String url = null;
		
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		System.out.println("num : " +num);
		System.out.println("pass : " +pass);
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO vo = bDao.selectOneByNum(Integer.parseInt(num));
		
		if(vo.getPass().equals(pass)) {
			url = "/board/checkSuccess.jsp"; //비번 맞다.
		}else {
			url = "/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
