//BoardForm.js
const del = document.getElementById("delete");
const frm = document.getElementById("frm");

del.addEventListener("click", function(){
    let check = window.confirm("정말 삭제ㄱ?");
    if(check){
        frm.setAttribute("action","./delete");
        frm.setAttribute("method","post");
        frm.submit();
    }

})