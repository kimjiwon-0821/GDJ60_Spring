<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>BankBook Detail Page</h1>
	<c:if test="${not empty dto}">
	<h3>Num : ${requestScope.dto.bookNum}</h3>
	<h3>Title : ${requestScope.dto.bookName}</h3>
	<h3>Detail : ${requestScope.dto.bookDetail}</h3>
	<h3>Rate : ${requestScope.dto.bookRate}</h3>
	<h3>Sale : ${requestScope.dto.bookSale}</h3>
	<div>
		<c:if test="${not empty dto.bankBookImgDTO}">
			<img src="../resources/upload/bankBook/${dto.bankBookImgDTO.fileName}">
		</c:if>
	</div>
	
	<a href="./delete?bookNum=${dto.bookNum}">상품삭제</a>
	</c:if>
	
	
	<c:if test="${empty dto}">해당 상품이 존재하지 않습니다.</c:if>
	<a href="./update?bookNum=${dto.bookNum}">상품 수정</a>
	<a href="./list">목록으로</a>
	
	<div class="my-5" id="commentListResult">



	</div>
	<!-- 댓글작성 -->
	<div class="my-5">
		
		<div class="mb-3">
			<textarea class="form-control" rows="3" id="replyContents"></textarea>
		</div>
		<div class="mb-3">
			<button type="button" class="btn btn-primary" id="replyAdd" data-book-bookNum="${dto.bookNum}">댓글작성</button>
		</div>

	</div>

	<!-- Update Form Modal -->
		<div class="modal fade" id="contentsModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="form-floating">
							<textarea class="form-control" placeholder="Leave a comment here" id="contents"></textarea>
							<label for="contents">Comments</label>
						  </div>
					</div>
					<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="closeModal">Cancel</button>
					<button type="button" class="btn btn-primary" data-comment-num="" id="contentsConfirm">Save</button>
					</div>
				</div>
			</div>
		</div>

		
<c:import url="../template/common_js.jsp"></c:import>
<script src="/resources/js/bankBookReply.js"></script>	
	

</body>
</html>