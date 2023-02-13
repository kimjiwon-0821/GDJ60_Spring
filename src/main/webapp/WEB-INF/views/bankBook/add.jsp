<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>

<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid">
	<div class="row col-md-7">
		<h1>BankBook Add Page</h1>
	</div>
	
	<div class="row justify-content-center">
		<form class="col-md-7" action="./add" method = "post">
			<div class="mb-3">
				<label for="bookName" class="form-label">제품명</label>
	    		<input type="text" name="bookName" class="form-control" id="bookName"  placeholder="제품명 입력">
			</div>
			<div class="mb-3">
				<label for="bookDetail" class="form-label">상세정보</label>
	    		<textarea name="bookDetail" class="bookDetail" id="bookDetail" placeholder="상세정보 입력" rows="7"></textarea>
			</div>
			<div class="mb-3">
				<label for="bookRate" class="form-label">이자율</label>
	    		<input type="text" name="bookRate" class="form-control" id="bookRate"  placeholder="제품명 입력">
			</div>
			
			<div class="mb-3">
				<fieldset>
					<legend>판매여부</legend>
					<label for="bs1" >판매</label>
					<input id="bs1" type="radio" checked name="bookSale" value ="1">
					<label for="bs2">판매중단</label>
					<input id="bs2" type="radio" name="bookSale" value = "0">
				</fieldset>
			</div>
			<div class="mb-3">
				<button class="btn btn-outline-success" type="submit">전송</button>
			</div>
		</form>
	</div>
</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>