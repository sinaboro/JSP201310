package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis  =request.getRequestDispatcher("product/productWriter.jsp");
		dis.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		int sizeLimit = 20*1024*1024;
		String encType = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				path,
				sizeLimit,
				encType,
				new DefaultFileRenamePolicy()
				);
		
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		
		String pictureurl = multi.getFilesystemName("pictureurl");
		
		System.out.println("name ===> " +  name);
		
		ProductVO vo = new ProductVO();
		vo.setName(name);
		vo.setPrice(price);
		vo.setDescription(description);
		vo.setPictureurl(pictureurl);
		
		ProductDAO pDao = ProductDAO.getInstance();
		int result = pDao.insertProduct(vo);
		
		if(result == 1 ) {
			response.sendRedirect("product.do");
		}else {
			response.sendRedirect("productWrite.do");
		}
		
	}
}


















