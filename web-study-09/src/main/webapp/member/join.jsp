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
  <h2>회원가입</h2>
  <form action="join.do" method="post" name="frm">
    <div class="form-group">
      <label for="name">이름:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>
    
    <div class="form-group">
      <label for="userid">아이디:</label> 
      <input type="button" value="중복체크"  class="btn btn-info btn-sm float-right" onclick="idCheck()">
      <input type="text" class="form-control" id="userid" placeholder="Enter usrid" name="userid">
      <input type="hidden" name="reid">
    </div>
    
    <div class="form-group">
      <label for="pwd">암호:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <div class="form-group">
      <label for="pwd_check">암호확인:</label> 
      <input type="password" class="form-control" id="pwd_check" placeholder="Enter password" name="pwd_check">
    </div>
    <div class="form-group">
      <label for="email">이메일:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="form-group">
      <label for="phone">전화번호:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone">
    </div>
     <div class="form-group">
  	   <label for="phone">등급:</label><br>
	    <input type="radio" name=admin" value="0" checked="checked">일반회원
	    <input type="radio" name=admin" value="1" >관리자
    </div>
    <button type="submit" class="btn btn-primary" >확인</button>&nbsp;&nbsp;
	<button type="reset" class="btn btn-secondary">취소</button>&nbsp;&nbsp;
  </form>
</div>

</form>
</body>
</html>









