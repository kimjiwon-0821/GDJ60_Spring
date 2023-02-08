<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Detail Page</h1>
	<c:if test="${not empty dto  }">
	<h3>Num : ${requestScope.dto.bookNum }</h3>
	<h3>Title : ${requestScope.dto.bookName}</h3>
	<h3>Detail : ${requestScope.dto.bookDetail}</h3>
	<h3>Rate : ${requestScope.dto.bookRate}</h3>
	<h3>Sale : ${requestScope.dto.bookSale}</h3>
	<a href="./delete?bookNum=${dto.bookNum }">상품삭제</a>
	</c:if>
	<c:if test="${empty dto}">해당 상품이 존재하지 않습니다.</c:if>
	<a href="./list">목록으로</a>
	

</body>
</html>