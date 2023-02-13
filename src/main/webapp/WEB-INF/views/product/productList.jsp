<%@page import="com.iu.s1.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
 <link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1 class="title"> product List</h1>
	
	<table class="tbl2">
		<thead>
			<tr>
				<th>상품명</th><th>평점</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto"> <!-- dto는 page영역에 담김 -->
				<tr>
					<td><a href="./detail?productNum=${dto.productNum}">${pageScope.dto.productName}</a></td>
					<td>${dto.productJumsu }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-danger" href = "./productAdd">상품등록</a>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>