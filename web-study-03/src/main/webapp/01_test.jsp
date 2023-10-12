<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int num1 = 20;
	int num2 = 10;
	int add = num1+num2;
	
	List<Integer> number = new ArrayList<>();
	List<String> str = new LinkedList<>();
	 
	out.print(num1 + " + " + num2 + " = " + add + "<br>");
	
	Calendar date = Calendar.getInstance();
	
	SimpleDateFormat today = new SimpleDateFormat("yyyy년 MM월 dd일");
	out.println(today.format(date.getTime()));
%>
</body>
</html>