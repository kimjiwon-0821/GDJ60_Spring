<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">

	<div class="row mb-4 ">
		<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">${boardName} Detail Page</h1>
	</div>
	
	<div class = "container-fluid">
		<div class = "row">
			<h3>${dto.title}</h3>
			<h3>${dto.writer}</h3>
			<h3>${dto.regDate}</h3>
			<h3>${dto.hit}</h3>
			<h1>${dto.contents}</h3>
			
		</div>
		<div class="row">
			<c:if test="${boardName ne 'notice'}">
				<a href="./reply?num=${dto.num}" class="btn btn-danger">답글</a>
			</c:if>
		</div>
	</div>
</div>
	

<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>