<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<!-- include summernote css/js-->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">
   <div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
     <p class="fs-2" >BankBook Add Page</p>
   </div>
   <form action="./add" method = "post" enctype="multipart/form-data">
      <div class="row col-md-4 mx-auto my-5">
         <div class="fw-bold fs-5 col-12">
            <p>이름</p>
            <input type="text" name="bookName" class="form-control" id="exampleFormControlInput1" placeholder="상품명 입력"><br>
         </div>
         <div class="fw-bold fs-5 col-12">
            <p>상세 정보</lp>
            <textarea name="bookDetail" class="form-control" id="bookDetail" rows="3" placeholder="상세 정보 입력"></textarea><br>
         </div>
         <div class="fw-bold fs-5 col-12">
            <p>이자율</p>
            <input type="text" name="bookRate" class="form-control" id="exampleFormControlInput1" placeholder="이자율 입력"><br>
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

		<!-- 파일추가 -->  
      <div id="filelist">
         <!-- <div class="input-group">
                  <input type="file" class="form-control" id="files" name="multipartFile"aria-describedby="inputGroupFileAddon04">
                  <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04">Button</button>
         </div>          -->
         
         <button id="fileAdd" type="button">add</button>
       </div>  


         <div class="row justify-content-center my-5">
            <button type="submit" class="btn btn-outline-warning col-2">전송</button>
         </div>
      </div>
   </form>
</div>
<script src="../resources/js/fileManager.js"></script>
<script>
   setMax(3);
   $("#bookDetail").summernote();
   setParam('f');
</script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>