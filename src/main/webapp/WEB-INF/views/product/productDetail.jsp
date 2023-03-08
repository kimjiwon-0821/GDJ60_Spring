<%@page import="com.iu.s1.product.ProductDTO"%>
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
		<div class = "row col-md-4 mx-auto my-5">
			<% ProductDTO productDTO=(ProductDTO) request.getAttribute("dto"); %>
			<h3><%=productDTO.getProductName() %></h3>
			<h3><%= productDTO.getProductDetail() %></h3>
			
			<hr>
			<h3>${requestScope.dto.productName}</h3>
			<h3>${requestScope.dto.productDetail}</h3>
			<h3>${dto.productJumsu*dto.productJumsu}</h3>
		</div>
	</div>
</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>