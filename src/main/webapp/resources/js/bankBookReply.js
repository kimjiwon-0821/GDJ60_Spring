const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("commentListResult");
const pageLink = document.querySelectorAll(".page-link");

replyAdd.addEventListener("click", function(){

    let xhttp = new XMLHttpRequest();

    xhttp.open("POST", "../bankBookComment/add");

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send("contents="+replyContents.value+"&bookNum="+replyAdd.getAttribute('data-book-bookNum'));

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4&&this.status==200){
            if(this.responseText.trim()==1){
                alert('댓글이 등록 되었습니다')
                replyContents.value="";
                getList(1);
            }else {
                alert('댓글 등록에 실패 했습니다')
            }

        }
    })

})

getList(1);

function getList(page){
    let count=0;
    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "/bankBookComment/list?bookNum="+replyAdd.getAttribute('data-book-bookNum')+"&page="+page);

    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4&&this.status==200){
            commentListResult.innerHTML=this.responseText.trim();
            count++;
        }        
    });
    //xhttp.send();
    //0이 출력됨 : 비동기 방식이기 때문
    console.log(count);
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
        let xhttp = new XMLHttpRequest();
        xhttp.open("POST", "../bankBookComment/delete");
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("num="+del.getAttribute("data-comment-num"));
        xhttp.addEventListener("readystatechange", function(){
            if(this.readyState==4&&this.status==200){
                let result = this.responseText.trim();
                if(result>0){
                    alert('댓글이 삭제되었습니다.');
                    getList(1);
                }else{
                    alert('삭제 실패');
                }
            }        
        });
    }
    e.preventDefault();
});

//update
commentListResult.addEventListener("click", function(e){
    let upd = e.target;
    if(upd.classList.contains("upd")){
        let xhttp = new XMLHttpRequest();
        xhttp.open("Post", "../bankBookComment/update");
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("num="+upd.getAttribute("data-comment-num")+"&contents="+
        replyContents.value+"&bookNum="+replyAdd.getAttribute('data-book-bookNum'));
        xhttp.addEventListener("readystatechange", function(){
            if(this.readyState==4&&this.status==200){
                let result = this.responseText.trim();
                if(result>0){
                    console.log("update")
                    alert('댓글이 수정되었습니다.');
                    getList(1);
                }else{
                    alert('수정 실패');
                }
            }        
        });
    }
    e.preventDefault();
});