let d1 = document.getElementById("d1")
const input1 = document.getElementById("input1");
const input2 = document.getElementById("input2");
const input3 = document.getElementById("input3");
const btn = document.getElementById("btn");

d1.addEventListener("click",function(){
    console.log("click event");
})
d1.addEventListener("mouseenter",function(){
    console.log("mouserenter event");
})
input1.addEventListener("keyup",function(){
    console.log("keyup event");
})
input2.addEventListener("focus",function(){
    console.log("focus event");
})
input2.addEventListener("blur",function(){
    console.log("blur event");
})
input2.addEventListener("change",function(){
    console.log("change event");
})
input3.addEventListener("change",function(){
    console.log(input3.value);
},true)
btn.onclick=function(){
    input2.focus();
};