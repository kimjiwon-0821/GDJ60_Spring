<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Update Page</h1>
	<form action="./update" method="post">
		<input type="hidden" name="bookNum" value="${dto.bookNum }">
		이름
		<input type="text" name = "bookName" value="${dto.bookName}" ><br>
		상세정보
		<textarea name="bookDetail" rows="" cols="">${dto.bookDetail}</textarea><br>
		이자율
		<input type="text" name="bookRate" value="${dto.bookRate}"><br>
		판매여부
		<input type="number" name = "bookSale" value="${dto.bookSale}"><br>
		<button type="submit">수정</button>
	</form>

</body>
