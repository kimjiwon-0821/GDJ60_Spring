<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>

<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid">
	<div class = "row col-md-7">
		<h1> member Add Page</h1>
	</div>
	
	<div class = "row justify-content-center">
      <form class="col-md-7" action="./memberAdd" method="post">
         <div class="mb-3">
			<label for="id" class="form-label">아이디</label>
	    	<input type="text" name="id" class="form-control" id="id"  placeholder="아이디 입력">
		</div>
        <div class="mb-3">
			<label for="pw" class="form-label">비밀번호</label>
	    	<input type="text" name="pw" class="form-control" id="pw"  placeholder="비밀번호 입력">
		</div>
        <div class="mb-3">
			<label for="name" class="form-label">이름</label>
	    	<input type="text" name="name" class="form-control" id="name"  placeholder="이름 입력">
		</div>
        <div class="mb-3">
			<label for="phone" class="form-label">전화번호</label>
	    	<input type="text" name="phone" class="form-control" id="phone"  placeholder="전화번호 입력">
		</div>
        <div class="mb-3">
			<label for="email" class="form-label">이메일</label>
	    	<input type="text" name="email" class="form-control" id="email"  placeholder="이메일 입력">
		</div>
		<div class="mb-3">
				<button class="btn btn-primary col-6" type="submit">등록</button>
		</div>
      </form>
   </div>
</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>