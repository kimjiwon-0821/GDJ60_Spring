<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my page</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid  my-5">
	<div class="row mb-4 ">
		<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">Member Page</h1>
	</div>
	<div class="row col-md-4 mx-auto my-5">
		<div class="row justify-content-center">
			<h3>Id : ${member.id }</h3>
			<h3>Password : ${dto.pw}</h3>
			<h3>Name : ${dto.name}</h3>
			<h3>Phone : ${dto.phone}</h3>
			<h3>Email : ${dto.email}</h3>
			<h3>Role : ${dto.roleDTO.roleName}</h3>
		 </div>
		<div class="row justify-content-center my-5">
			<a href="./memberUpdate" class="btn btn-outline-primary">정보수정</a>
			<a href=# class="btn btn-danger">회원 탈퇴</a>
		</div>
	</div>
</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>