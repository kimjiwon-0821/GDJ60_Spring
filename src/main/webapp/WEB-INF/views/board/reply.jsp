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
   <div class="row col-md-4 mx-auto text-center border-bottom border-dark pb-2">
     <p class="fs-2" style="font-family: 'Impact'">${boardName} Reply Page</p>
   </div>
   <form action="./reply" method = "post" enctype="multipart/form-data">
   	 <input type="hidden" name="num" value="${boardDTO.num}">
      <div class="row col-md-4 mx-auto my-5">
         <div class="fw-bold fs-5 col-12">
            <p>작성자</p>
            <input type="text" name="writer" class="form-control" id="writer" placeholder="이름 입력"><br>
         </div>
         <div class="fw-bold fs-5 col-12">
            <p>제목</p>
            <input type="text" name="title" class="form-control" id="title" placeholder="제목 입력"><br>
         </div>  
         <div class="fw-bold fs-5 col-12">
            <p>내용</lp>
            <textarea name="contents" class="form-control" id="contents" rows="3" placeholder="내용 입력"></textarea><br>
         </div>
		</div>       
              

		<!-- 파일추가 -->  
      <!-- <div id="filelist">
         <div class="fw-bold fs-5 col-12 mt-3">
            <label for="files" class="form-label">Image</label>
            <input type="file" class="form-control" id="files" name="multipartFile">
         </div>         
         <button id="fileAdd" type="button">add</button>
       </div>  --> 


         <div class="row justify-content-center my-5">
            <button type="submit" class="btn btn-outline-warning col-2">전송</button>
         </div>
      </div>
   </form>
</div>
<script src="../resources/js/fileManager.js"></script>
<script>
   setMax(3);
   setParam('f');
</script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>