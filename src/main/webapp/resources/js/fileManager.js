const fileAdd=document.getElementById("fileAdd");
const filelist = document.getElementById("filelist");
let count=0;
let max=1;
let param="multipartFile";
let idx = 0;

function setParam(p){
    param=p;
}

function setMax(m){
    max=m;
}

filelist.addEventListener("click",function(e){
    if(e.target.classList.contains('dels')){
        e.target.parentNode.remove();
        // let id = e.target.getAttribute('data-dels-id');
        // document.getElementById(id).remove();
        count--;
    }

});



fileAdd.addEventListener("click",function(){
    console.log("fileAdd Click");
    if(count==max){
        alert("첨부파일은 최대 "+max+"개까지 업로드 가능합니다.");
        return ;
    }else{
        //Element, Text 생성
        let div=document.createElement("div"); //부모div
        let input = document.createElement("input");
        let btn = document.createElement("button");
        let n = document.createTextNode("X");

        //Attribure 생성
        //div attribute
        let attr = document.createAttribute("class")
        attr.value='input-group mb-3'
        div.setAttributeNode(attr);

        attr = document.createAttribute("id");
        attr.value = 'f'+idx;
        div.setAttributeNode(attr);

        //input attribute
        let arrtI =document.createAttribute("type");
        arrtI.value='file'
        input.setAttributeNode(arrtI);
        arrtI = document.createAttribute("class")
        arrtI.value='form-control'
        input.setAttributeNode(arrtI);
        arrtI=document.createAttribute("id");
        arrtI.value='files'
        input.setAttributeNode(arrtI);
        arrtI=document.createAttribute("name");
        arrtI.value=param;
        input.setAttributeNode(arrtI);

        //btn attribute
        attr = document.createAttribute("type");
        attr.value="button";
        btn.setAttributeNode(attr);
        attr = document.createAttribute("class");
        attr.value="btn btn-outline-primary dels";
        btn.setAttributeNode(attr);
        btn.appendChild(n);

        attr = document.createAttribute('data-dels-id');
        attr.value = 'f'+idx;
        btn.setAttributeNode(attr);
        
        //Element 조립
        div.appendChild(input);
        div.appendChild(btn);
        filelist.prepend(div)
        count++;
        idx++;
        
        // btn.addEventListener("click",function(){
        //     div.remove();
        //     count--;
        // })
    }
})