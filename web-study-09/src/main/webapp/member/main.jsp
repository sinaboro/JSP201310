<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="./script/member.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h2>회원 전용 페이지</h2>
  <form action="logout.do">
    안녕하세요 ${loginUser.name}(${loginUser.userid })님<br><br>
	<button type="submit" class="btn btn-secondary">로그아웃</button>&nbsp;&nbsp;
	<button type="button" class="btn btn-success" 
		onclick="location.href='memberUpdate.do?userid=${loginUser.userid}'">
	회원정보변경</button>
  </form>
</div>

</form>
</body>
</html>