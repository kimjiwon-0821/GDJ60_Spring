const d1= document.getElementById("d1");

let n='IU';
var old='iu';
//function 선언
function f1(){
    console.log("function Test");
    var old="winter";
}

//매개변수 선언시 let,const는 생략해야 함
function f2(n1, n2){
    let name = 'iu';
    return n1+n2;
}

//function 호출
f1();
let result = f2(9,1);
console.log(result);
// console.log(name);
// console.log(n1);
console.log("old"+old);

let fun=function(){
    console.log('익명함수');
    return 1;
}

function f3(fun){
    console.log("f3: ",fun,1);
}
f3(fun());

function callback1(){
    console.log("callback1");
}
let callback2 = function(){
    console.log("callback2");
}//익명함수 -> 즉 변수에 이름을 담아서 사용.

//다른곳에서도 같은 함수를 사용하고 싶을때 사용하는 방법
//d1.addEventListener("click",callback2);
//클랙했을 경우만 사용하고 싶은 경우-익명함수 사용.
//여기에서만 사용
d1.addEventListener("click",function(){
    callback1();
    callback2();
});


