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
<title>Insert title here</title>
<style type="text/css">
	.container{
		margin-top: 30px;
	}
	th{
	 text-align: center;
	}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
  <h2>회원전용페이지</h2>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th colspan="2" >로그인</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>아이디</td>
        <td>
        	<input type="text" name=id placeholder="아이디를 입력해주세요" size="50">
        </td>
      </tr>
      <tr >
        <td>비밀번호</td>
        <td>
        	<input type="password" name=pass placeholder="비밀번호를 입력해주세요" size="50">
        </td>
      </tr>

      <tr>
        <td>레벨</td>
        <td>
        	<select name="lev" >
				<option value = "A">운영자</option>
				<option value = "B">일반회원</option>
			</select></td>
      	</tr>
      <tr>
        <td colspan="2">
        	<button type="submit" class="btn btn-primary">로그인</button>&nbsp;&nbsp;&nbsp;
			<button type="reset" class="btn btn-secondary">취소</button>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>