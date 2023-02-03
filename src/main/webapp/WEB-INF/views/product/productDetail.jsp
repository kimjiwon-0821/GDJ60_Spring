<%@page import="com.iu.s1.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>product Detail</h1>
	<% ProductDTO productDTO=(ProductDTO) request.getAttribute("dto"); %>
	<h3><%=productDTO.getPRODUCTNAME() %></h3>
	<h3><%= productDTO.getPRODUCTDETAIL() %></h3>
	
	<hr>
	<h3>${requestScope.dto.PRODUCTNAME}</h3>
	<h3>${requestScope.dto.PRODUCTDETAIL}</h3>
	<h3>${dto.PRODUCTJUMSU*dto.PRODUCTJUMSU}</h3>
</body>
</html>