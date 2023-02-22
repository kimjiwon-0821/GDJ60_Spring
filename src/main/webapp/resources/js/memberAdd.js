const id = document.getElementById("id");
const idResult = document.getElementById("idResult");
const pw = document.getElementById("pw");
const pwResult = document.getElementById("pwResult");
const pwcheck = document.getElementById("pwcheck");
const pwCheckResult = document.getElementById("pwCheckResult");
const user = document.getElementById("name");
const userResult = document.getElementById("nameResult");
const phone = document.getElementById("phone");
const phoneResult = document.getElementById("phoneResult");
const email = document.getElementById("email");
const emailResult = document.getElementById("emailResult");
const frm = document.getElementById("frm");
const btn = document.getElementById("btn");
let idCheck=false;
let pwLengthCheck = false;
let pwNullCheck=false;
let pwEqualCheck=false;
let userCheck=false;
let phoneCheck=false;
let emailCheck=false;
//let checks=[false,false,false,false,false,false,false]

//ID 검증
id.addEventListener("blur",function(){
    if(id.value.length!=0){
        idResult.innerHTML='정상적인 ID';
        idCheck=true;
        idResult.classList.add("blueResult")
        idResult.classList.remove("redResult")
        //checks[0]=true;
    }else{
        idResult.innerHTML='ID는 필수입니다.';
        idCheck=false;
        idResult.classList.add("redResult")
        idResult.classList.remove("blueResult")
    }
});

//pw 검증
pw.addEventListener("keyup",function(){
    if(pw.value.length>5 && pw.value.length<13){
        pwResult.innerHTML='정상비번'
        pwLengthCheck=true;
        pwResult.classList.add("blueResult")
        pwResult.classList.remove("redResult")
        //checks[1]=true;
    }else{
        pwResult.innerHTML='비번은 6자 이상 12자 이하여야 합니다'
        pwLengthCheck=false;
        pwResult.classList.add("redResult")
        pwResult.classList.remove("blueResult")

    }
})

pw.addEventListener("blur",function(){
    if(pw.value!=''){
        pwNullCheck=true;
        //chescks[2]=true;
    }else{
        pwResult.innerHTML='PW는 필수입니다.'
        pwNullCheck=false;
        pwResult.classList.add("redResult")
        pwResult.classList.remove("blueResult")
    }
});

pw.addEventListener("change",function(){
    pwEqualCheck=false;
    pwcheck.value='';
    pwCheckResult.innerHTML='pw가 틀립니다.'
    pwCheckResult.classList.add("redResult")
    pwCheckResult.classList.remove("blueResult")
})

//pw Equal 검증
pwcheck.addEventListener("blur",function(){
    if(pwcheck.value==pw.value){
        pwCheckResult.innerHTML="동일한 pw"
        pwEqualCheck=true;
        pwCheckResult.classList.add("blueResult")
        pwCheckResult.classList.remove("redResult")
    }else{
        pwCheckResult.innerHTML='pw가 틀립니다';
        pwEqualCheck=false;
        pwCheckResult.classList.add("redResult")
        pwCheckResult.classList.remove("blueResult")
    }
})

//name 검증
user.addEventListener("blur",function(){
    if(user.value.length!=0){
        userResult.innerHTML='';
        userCheck=true;
        userResult.classList.add("blueResult")
        userResult.classList.remove("redResult")
    }else{
        userResult.innerHTML='이름은 필수입니다.';
        userCheck=false;
        userResult.classList.add("redResult")
        userResult.classList.remove("blueResult")
    }
});

//phone 검증
phone.addEventListener("blur",function(){
    if(phone.value.length!=0){
        phoneResult.innerHTML='';
        phoneCheck=true;
        phoneResult.classList.add("blueResult")
        phoneResult.classList.remove("redResult")
    }else{
        phoneResult.innerHTML='전화번호는 필수입니다.';
        phoneCheck=false;
        phoneResult.classList.add("redResult")
        phoneResult.classList.remove("blueResult")
    }
});

//email 검증
email.addEventListener("blur",function(){
    if(email.value.length!=0){
        emailResult.innerHTML='';
        emailCheck=true;
        emailResult.classList.add("blueResult")
        emailResult.classList.remove("redResult")
    }else{
        emailResult.innerHTML='이메일은 필수입니다.';
        emailCheck=false;
        emailResult.classList.add("redResult")
        emailResult.classList.remove("blueResult")
    }
});

//form 전송
btn.addEventListener("click",function(){
    //if(!checks.includes(false)) ->회원가입성
    if(idCheck&&pwLengthCheck&&pwNullCheck&&pwEqualCheck&&userCheck&&phoneCheck&&emailCheck){
        frm.submit();
    }else{
        alert("필수사항을 작성해 주세요.")
    }
})