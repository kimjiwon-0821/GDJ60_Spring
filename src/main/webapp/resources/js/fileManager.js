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

function setCount(c){
    count=c;
}

$(".deleteCheck").click(function(){
    let result = confirm("파일이 영구히 삭제됩니다!");
    let ch = $(this);
    if(result){
        let fileNum = $(this).val();
        $.ajax({
            type:'POST',
            url:'./boardFileDelete',
            data:{
                fileNum:fileNum //속성명:변수명
            },
            success:function(responces){
                if(responces.trim()>0){
                    alert("삭제되었습니다");
                    //this : ajax 객체 자기 자신
                    console.log(ch)
                    ch.parent().parent().remove();
                    count--;
                }else{
                    alert("삭제 실패<br> 관리자에게 문의 요망");
                }
            },
            error:function(){

            }
        })

        //Ajax DB에서 삭제
        //fetch-GET
        // fetch("URL?p=1",{
        //     method:"GET"
        // }).then((responces)=>responces.text())
        // .then((res)=>{...})

        //jquery-get
        // $.get("URL?p=1",function(response){
        //     //...
        // })

        //fetch-post
        // fetch("URL",{
        //     method:'POST',
        //     headers:{
        //         'contents-Type':'X'
        //     },
        //     body:"p=1"
        // }).then((responces)=>responces.text())
        // .then((res)=>{...})

        //jquery-POST
        //$.post("URL",{p:1},function(res){})

        //jquery-GET/POST 통합
        //상단에 코드 있음.

    }else{
        $(this).prop('checked',false);
    }
    
})

//JS
// filelist.addEventListener("click",function(e){
//     if(e.target.classList.contains('dels')){
//         e.target.parentNode.remove();
//         // let id = e.target.getAttribute('data-dels-id');
//         // document.getElementById(id).remove();
//         count--;
//     }

// });
//Jquery
$("#filelist").on("click",".dels",function(e){
    // let id = $(this).attr("data-dels-id");
    // $("#"+id).remove();
    $(this).parent().remove();
    count--;
})


//JS
//create해도 되고,
// fileAdd.addEventListener("click",function(){
//     console.log("fileAdd Click");
//     if(count==max){
//         alert("첨부파일은 최대 "+max+"개까지 업로드 가능합니다.");
//         return ;
//     }else{
//         //Element, Text 생성
//         let div=document.createElement("div"); //부모div
//         let input = document.createElement("input");
//         let btn = document.createElement("button");
//         let n = document.createTextNode("X");

//         //Attribure 생성
//         //div attribute
//         let attr = document.createAttribute("class")
//         attr.value='input-group mb-3'
//         div.setAttributeNode(attr);

//         attr = document.createAttribute("id");
//         attr.value = 'f'+idx;
//         div.setAttributeNode(attr);

//         //input attribute
//         let arrtI =document.createAttribute("type");
//         arrtI.value='file'
//         input.setAttributeNode(arrtI);
//         arrtI = document.createAttribute("class")
//         arrtI.value='form-control'
//         input.setAttributeNode(arrtI);
//         arrtI=document.createAttribute("id");
//         arrtI.value='files'
//         input.setAttributeNode(arrtI);
//         arrtI=document.createAttribute("name");
//         arrtI.value=param;
//         input.setAttributeNode(arrtI);

//         //btn attribute
//         attr = document.createAttribute("type");
//         attr.value="button";
//         btn.setAttributeNode(attr);
//         attr = document.createAttribute("class");
//         attr.value="btn btn-outline-primary dels";
//         btn.setAttributeNode(attr);
//         btn.appendChild(n);

//         attr = document.createAttribute('data-dels-id');
//         attr.value = 'f'+idx;
//         btn.setAttributeNode(attr);
        
//         //Element 조립
//         div.appendChild(input);
//         div.appendChild(btn);
//         filelist.prepend(div)
//         count++;
//         idx++;
        
//         // btn.addEventListener("click",function(){
//         //     div.remove();
//         //     count--;
//         // })
//     }
// })

//Jquery
//문자열로 만들어도 됨.
$("#fileAdd").click(()=>{
    if(count>=max){
        alert("첨부파일은 최대 "+max+"개까지 업로드 가능합니다.");
        return ;
        }else{
            let child = '<div class="input-group mb-3" id="f'+idx+'">'
                child = child+'<input type="file" class="form-control" name="'+param+'">'
                child = child+'<button type="button" class="btn btn-outline-primary dels" data-dels-id="f'+idx+'">X</button>'
            $("#filelist").append(child);
            count++;
            idx++;

        }
})


