<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
	<h1 class="title">BankBook List Page</h1>

	<div class="kong">
	<img  alt="메롱콩이" src="../resources/images/kong.jpg" width="400" height="400">
	</div>

	<table border="1" class="tb1">
		<thead>
			<tr>
				<th>상품명</th>
				<th>이자율</th>
				<th>판매여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><a href="./detail?bookNum=${dto.bookNum}">${dto.bookName}</a></td>
					<td>${dto.bookRate}</td>
					<td><c:if test="${dto.bookSale eq 1}">판매중</c:if> 
						<c:if test="${dto.bookSale eq 0}">판매중단</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="./add">상품등록</a>

</body>
</html>