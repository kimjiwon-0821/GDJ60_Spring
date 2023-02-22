const fileAdd=document.getElementById("fileAdd");
const filelist = document.getElementById("filelist");
let count=0;
let max=1;
let param="multipartFile";

function setParam(p){
    param=p;
}

function setMax(m){
    max=m;
}

fileAdd.addEventListener("click",function(){
    console.log("fileAdd Click");
    if(count==max){
        alert("첨부파일은 최대 "+max+"개까지 업로드 가능합니다.");
        return ;
    }else{
        //Element, Text 생성
        let div=document.createElement("div"); //부모div
        let label = document.createElement("label");
        let input = document.createElement("input");
        let text = document.createTextNode("이미지");

        //Attribure 생성
        //div attribute
        let attr = document.createAttribute("class")
        this.attributes.value='mb-3'
        div.setAttributeNode(attr);

        //label attribute
        let arrtL = document.createAttribute("for");
        arrtL.value='files';
        label.setAttributeNode(arrtL);
        arrtL=document.createAttribute("calss");
        arrtL.value='form-label';
        label.setAttributeNode(arrtL);

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

        //Element 조립
        label.appendChild(text);
        div.appendChild(label);
        div.appendChild(input);
        filelist.prepend(div)
        count++;
    }
})