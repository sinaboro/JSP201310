<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
  <h2>회원정보수정</h2>
  <form action="memberUpdate.do" method="post" name="frm">
  
    <div class="form-group">
      <label for="name">이름:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value=${mVo.name}>
    </div>
    
    <div class="form-group">
      <label for="userid">아이디:</label> 
      <input type="text" class="form-control" id="userid" placeholder="Enter usrid" name="userid" value=${mVo.userid} readonly="readonly">
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
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" value=${mVo.email}>
    </div>
    <div class="form-group">
      <label for="phone">전화번호:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone" value=${mVo.phone}>
    </div>
    
    
    <c:if test="${mVo.admin == 0}">
	     <div class="form-group">
	  	   <label  >등급:</label><br>
		    <input type="radio" name=admin value="0" checked="checked">일반회원
		    <input type="radio" name=admin value="1" >관리자
	    </div>
    </c:if>

    <c:if test="${mVo.admin ==1}">
	     <div class="form-group">
	  	   <label  >등급:</label><br>
		    <input type="radio" name=admin value="0" >일반회원
		    <input type="radio" name=admin value="1" checked="checked">관리자
	    </div>
    </c:if>
    
    <button type="submit" class="btn btn-primary" >수정</button>&nbsp;&nbsp;
	<button type="reset" class="btn btn-secondary">취소</button>&nbsp;&nbsp;
  </form>
</div>

</form>
</body>
</html>









