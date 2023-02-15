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
<div class="container-fluid">
	<div class = "row col-md-7">
		<h1> member Login Page</h1>
	</div>
	
	<div class = "row justify-content-center">
      <form class="col-md-7" action="./memberLogin" method="post">
         <div class="mb-3">
			<label for="id" class="form-label">아이디</label>
	    	<input type="text" name="id" class="form-control" id="id"  placeholder="아이디 입력">
		</div>
        <div class="mb-3">
			<label for="pw" class="form-label">비밀번호</label>
	    	<input type="text" name="pw" class="form-control" id="pw"  placeholder="비밀번호 입력">
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