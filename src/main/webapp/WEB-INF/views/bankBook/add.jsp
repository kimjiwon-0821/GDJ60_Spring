<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Add Page</h1>
	<form action="./add" method = "post">
	<fieldset>
		<legend>이름</legend>
		<input type="text" name = "bookName" placeholder="제품명 입력">
	</fieldset>
	<fieldset>
		<legend>상세정보</legend>
		<textarea name="bookDetail" rows="" cols=""></textarea>"
	</fieldset>
	<fieldset>
		<legend>이자율</legend>
	<input type="text" name="bookRate">
	</fieldset>
	<fieldset>
		<legend>판매여부</legend>
		<label for="bs1" >판매</label>
		<input id="bs1" type="radio" checked name="bookSale" value ="1">
		<label for="bs2">판매중단</label>
		<input id="bs2" type="radio" name="bookSale" value = "0">
	</fieldset>
	
	<!-- <select name="bookSale">
		<option value="1">판매</option>
		<option selected value="0">판매중단</option>
	</select> -->
	
	<input type="submit" value="등록">
	<button type="submit">전송</button>
	</form>
</body>
</html>