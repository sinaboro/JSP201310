<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int age  = Integer.parseInt(request.getParameter("age"));

	if(age<=19){
%>	
	<h2>19세 미만 입력</h2>	
	<script>
		alert("19세 미만이므로 입장 불가능");
		history.go(-1);
	</script>
<%		
	}else{
		request.setAttribute("age", request.getParameter("age"));
		request.setAttribute("name", "성윤정");
		
	/*	RequestDispatcher dis =  
				 request.getRequestDispatcher("05_forwordResult.jsp"); 
		dis.forward(request, response); */
		
		//application.setAttribute("key", "1234");
		
		request.getRequestDispatcher("05_forwordResult.jsp")
			.forward(request, response);
	}
%>