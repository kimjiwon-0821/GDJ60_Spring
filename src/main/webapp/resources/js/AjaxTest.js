const btn = document.getElementById("btn");

btn.addEventListener("click",function(){
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET','/notice/list?page=1');
    xhttp.send(); //백그라운드에서 요청을 보냄
    xhttp.addEventListener('readystatechange',function(){
        if(this.readyState==4 && this.status==200){
            console.log("정상 요청 응답 종료");
            console.log(this.responseText);
        }
    });
});