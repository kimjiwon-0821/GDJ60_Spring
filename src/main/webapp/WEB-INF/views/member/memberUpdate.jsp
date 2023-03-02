<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid">
	<div class = "row col-md-7">
		<h1> member Update Page</h1>
	</div "row justify-content-center">
	<form class="col-md-7" action="./memberUpdate" method="post">
		<input type="hidden" name="id" value="${member.id}">
		<input type="hidden" name="pw" value="${member.pw}">
		<div class="mb-3">
			<label for="name" class="form-label">이름</label>
			<input type="text" name = "name" class="form-control" id="name" value="${dto.name}" >
		</div>
		<div class="mb-3">
			<label for="phone" class="form-label">이메일</label>
			<input type="text" name = "phone" class="form-control" id="phone" value="${dto.phone}" >
		</div>
		<div class="mb-3">
			<label for="email" class="form-label">이메일</label>
			<input type="text" name = "email" class="form-control" id="email" value="${dto.email}" >
		</div>
	
		<button type="submit" class="btn btn-outline-primary" >수정</button>
	</form>

</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>