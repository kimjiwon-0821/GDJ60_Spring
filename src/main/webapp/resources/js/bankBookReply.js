const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("commentListResult");
const pageLink = document.querySelectorAll(".page-link");
const contentsConfirm = document.getElementById("contentsConfirm");
const closeModal = document.getElementById("closeModal");

//댓글 등록
replyAdd.addEventListener("click", function(){
    console.log("num"+replyAdd.getAttribute('data-book-bookNum'));

    //JS에서 사용할 가상의 Form 태그 생성
    const form = new FormData(); //<form></form> 와 같음
    form.append("contents",replyContents.value); //<form><input type="text" name="contents" value="dfdf"></form>
    form.append("bookNum",replyAdd.getAttribute('data-book-bookNum')) //<form><input type="text" name="bookNum" value="1212"><input type="text" name="contents" value="dfdf"></form>

    fetch("../bankBookComment/add",{
        method:'POST',  //method 형식
        //headers:{"Content-type":"application/x-www-form-urlencoded"},    //header
        body:form,//body:서버로 전송할 데이터(parameter)
    }).then((response)=>response.text()) //응답
    .then((res)=>{
        if(res.trim()==1){
            alert('댓글이 등록 되었습니다')
            replyContents.value="";
            getList(1);
        }else{
            alert('댓글 등록에 실패 했습니다')
        }
    }).catch(()=>{
        console.log("error")
    })

    // let xhttp = new XMLHttpRequest();

    // xhttp.open("POST", "../bankBookComment/add");

    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // xhttp.send("contents="+replyContents.value+"&bookNum="+replyAdd.getAttribute('data-book-bookNum'));

    // xhttp.addEventListener('readystatechange', function(){
    //     if(this.readyState==4&&this.status==200){
    //         if(this.responseText.trim()==1){
    //             alert('댓글이 등록 되었습니다')
    //             replyContents.value="";
    //             getList(1);
    //         }else {
    //             alert('댓글 등록에 실패 했습니다')
    //         }

    //     }
    // })

})

//1을 넣어줘야함
getList(1);

function getList(page){
    //let count=0;
    
    fetch("/bankBookComment/list?bookNum="+replyAdd.getAttribute('data-book-bookNum')+"&page="+page,{
        method:"GET",
        //GET/Head Method는 body 속성을 가질수 없다.
    }).then((response)=>response.text())
    .then((res)=>{
        commentListResult.innerHTML=res.trim();
    })
    
    // let xhttp = new XMLHttpRequest();
    // xhttp.open("GET", "/bankBookComment/list?bookNum="+replyAdd.getAttribute('data-book-bookNum')+"&page="+page);

    // xhttp.send();

    // xhttp.addEventListener("readystatechange", function(){
    //     if(this.readyState==4&&this.status==200){
    //         commentListResult.innerHTML=this.responseText.trim();
    //         //count++;
    //     }        
    // });

    //xhttp.send();
    //0이 출력됨 : 비동기 방식이기 때문
    //console.log(count);
}
commentListResult.addEventListener("click", function(e){
    let pageLink = e.target;
    if(pageLink.classList.contains("page-link")){
        let page = pageLink.getAttribute("data-board-page");
        getList(page);
    }
    e.preventDefault();
});

//delete
commentListResult.addEventListener("click", function(e){
    let del = e.target;
    if(del.classList.contains("del")){

        fetch("../bankBookComment/delete",{
            method:"POST",
            headers:{"Content-type":"application/x-www-form-urlencoded"},
            body:"num="+del.getAttribute("data-comment-num")
        }).then((response)=>response.text()) //응답객체에서 data 추출
        .then((res)=>{  //추출 data 사용 단계
            if(res.trim()>0){
                alert('댓글이 삭제되었습니다.');
                getList(1);
            }else{
                alert('삭제 실패');
            }
        });

        // let xhttp = new XMLHttpRequest();
        // xhttp.open("POST", "../bankBookComment/delete");
        // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        // xhttp.send("num="+del.getAttribute("data-comment-num"));
        // xhttp.addEventListener("readystatechange", function(){
        //     if(this.readyState==4&&this.status==200){
        //         let result = this.responseText.trim();
        //         if(result>0){
        //             alert('댓글이 삭제되었습니다.');
        //             getList(1);
        //         }else{
        //             alert('삭제 실패');
        //         }
        //     }        
        // });
    }
    e.preventDefault();
});

//update
commentListResult.addEventListener("click", function(e){
    let upd = e.target;
    if(upd.classList.contains("upd")){
       let num = upd.getAttribute("data-comment-num");
       let contents = document.getElementById("contents"+num);//td
       let contentsTextArea = document.getElementById("contents");//Modal textarea
       contentsTextArea.value=contents.innerText;
       contentsConfirm.setAttribute("data-comment-num",num);
    }
    e.preventDefault();
});

contentsConfirm.addEventListener("click",function(){
    console.log("updatePost");
    let updateContents = document.getElementById("contents").value;
    let num = contentsConfirm.getAttribute("data-comment-num");

    fetch("../bankBookComment/update",{
        method:"POST",
        headers:{"Content-type":"application/x-www-form-urlencoded"},
        body:"num="+num+"&contents="+updateContents
    }).then((response)=>response.text())
    .then((res)=>{
        if(res.trim()>0){
            alert('수정 성공');
            closeModal.click();
            getList(1);
        }else{
            alert('수정 실패');
        }
    })
    .catch(()=>{
        alert('관리자 연락 요망')
    });

    // let xhttp = new XMLHttpRequest();
    //     xhttp.open("POST", "../bankBookComment/update");
    //     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //     xhttp.send("num="+num+"&contents="+updateContents);
    //     xhttp.addEventListener("readystatechange", function(){
    //         if(this.readyState==4&&this.status==200){
    //             let result = this.responseText.trim();
    //             if(result>0){
    //                 alert('수정 성공');
    //                 closeModal.click();
    //                 getList(1);
    //             }else{
    //                 alert('수정 실패');
    //             }
    //         }        
    //     });
});