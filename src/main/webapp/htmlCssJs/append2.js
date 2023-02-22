const d1 = document.getElementById("d1");
const add = document.getElementById("add");
const del = document.getElementById("del");
const result = document.getElementById("result");
const dels = document.getElementsByClassName("dels");

let idx = 0;

result.addEventListener("click",function(e){
    // console.log(e.currentTarget, e.target);
    // console.log(e.target.classList.contains("dels"));
    if(e.target.classList.contains("dels")){
        let id =e.target.getAttribute("data-delete-id");
        document.getElementById(id).remove();
    }
})

for(let i=0;i<dels.length;i++){
    dels[i].addEventListener("click", function(){
        console.log("dels");
    })
}
add.addEventListener("click",function(){
    let d = document.createElement("div");//부모div
    let btn = document.createElement("button");//delete버튼
    let n=document.createTextNode("DELETE");
    let attr = document.createAttribute("class");
    attr.value="dels";
    btn.setAttributeNode(attr);
    btn.appendChild(n);

    attr = document.createAttribute("data-delete-id")
    attr.value='del'+idx;
    btn.setAttributeNode(attr);
    d.appendChild(btn);

    //id
    attr = document.createAttribute("id");
    attr.value='del'+idx;
    d.setAttributeNode(attr);
    idx++;

    result.append(d);
})
d1.addEventListener("click",function(){
    d1.removeChild(h1[0]);
})

