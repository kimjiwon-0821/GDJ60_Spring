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
			<p>${dto.contents}</p>
			
			<c:forEach items="${dto.boardFileDTOs}" var="fileDTO">
				<a href="../resources/upload/${boardName}/${fileDTO.fileName}">${fileDTO.oriName}</a>
			</c:forEach>
		
			<c:if test="${boardName ne 'notice'}">
				<a href="./reply?num=${dto.num}" class="btn btn-info">답글</a>
			</c:if>
			
			<div>
				<form action="./update" id="frm">
					<input type="hidden" name="num" value="${dto.num}">
					<button id="update" type="submit" class="btn btn-primary">UPDATE</button>
					<button id="delete" type="button" class="btn btn-danger">DELETE</button>
				</form>
			</div>
		</div> 
	</div>
</div>
	

<c:import url="../template/common_js.jsp"></c:import>
<script type="text/javascript" src="../resources/js/boardForm.js"></script>
</body>
</html>