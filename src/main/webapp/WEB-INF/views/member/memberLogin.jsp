<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">
	<div class="row mb-4 ">
		<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">Member Login Page</h1>
	</div>
	
	<div class = "row justify-content-center">
      <form class="col-md-7" action="./memberLogin" method="post">
         <div class="mb-3">
			<label for="id" class="form-label">아이디</label>
	    	<input type="text" value="${cookie.rememberId.value}" name="id" class="form-control" id="id"  placeholder="아이디 입력">
		</div>
        <div class="mb-3">
			<label for="pw" class="form-label">비밀번호</label>
	    	<input type="text" name="pw" class="form-control" id="pw"  placeholder="비밀번호 입력">
		</div>
		<div>
			<input type="checkbox" name="remember" value="remember" class="form-check-input" id="">
			<label class="form-label">아이디 기억하기</label>
		</div>
		<div class="mb-3">
				<button class="btn btn-primary col-6" type="submit">로그인</button>
		</div>
      </form>
    	
      
   </div>
</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>

</html>