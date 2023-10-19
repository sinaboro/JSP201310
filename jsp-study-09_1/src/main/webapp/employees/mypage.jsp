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
<title>Insert title here</title>
<style type="text/css">
.container{
	margin-top: 30px;
}
th{
 text-align: center;
}
</style>
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<form action="login.do" method="post">
<div class="container">
  <table class="table table-bordered">
    <thead>
      <tr>
        <th colspan="2" >마이페이지</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>아이디</td>
        <td>
        	<input type="text" name=id  value=${mVo.id} size="50">
        </td>
      </tr>
      <tr >
        <td>비밀번호</td>
        <td>
        	<input type="password" name=pass value=${mVo.pass}  size="50">
        </td>
      </tr>

      <tr >
        <td>이름</td>
        <td>
        	<input type="text" name=name value=${mVo.name}  size="50">
        </td>
      </tr>
      <tr>
        <td>레벨</td>
	       <c:if test="${mVo.lev =='A'}">
	        <td>
	        	<select name="lev" >
					<option value = "A" selected="selected" >운영자</option>
					<option value = "B">일반회원</option>
				</select></td>
	      	</tr>
	      	</c:if>
	       <c:if test="${mVo.lev =='B'}">
	        <td>
	        	<select name="lev" >
					<option value = "A"  >운영자</option>
					<option value = "B" selected="selected">일반회원</option>
				</select></td>
	      	</tr>
	      	</c:if>
       <tr>
      <tr>
        <td>성별</td>
	       <c:if test="${mVo.gender =='1'}">
		        <td>
		        	<select name="gender" >
						<option value = "1" selected="selected" >남자</option>
						<option value = "2">여자</option>
					</select></td>
		      	</tr>
	      	</c:if>
	       <c:if test="${mVo.gender =='2'}">
		        <td>
		        	<select name="gender" >
						<option value = "1"  >남자</option>
						<option value = "2" selected="selected">여자</option>
					</select></td>
		      	</tr>
	      	</c:if>
       <tr>
       
       <tr >
        <td>전화번호</td>
        <td>
        	<input type="text" name=phone value=${mVo.phone}  size="50">
        </td>
      </tr>
      
        <td colspan="2">
        	<button type="submit" class="btn btn-primary">수정</button>&nbsp;&nbsp;&nbsp;
			<button type="reset" class="btn btn-secondary">취소</button>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>