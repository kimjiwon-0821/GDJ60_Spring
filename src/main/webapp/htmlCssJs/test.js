console.log("Hello world");

//변수 선언과 대입
//데이터타입 변수명;
let num1=3; //데이터타입이 변경되기 때문에 let로 선언
num1="abc";

//옛날버전, Hoisting에 문제 발생 -> 현재 쓰지 말것을 권장 (대체:let)
var num2 =4;

//상수형 변수
const num3=5;
//num3 = 6; // 에러발생 (java에서의 final함수와 같음) - 변하지 않는 변수

//연산자
let num4;
num4 = num1+num2;//-,*,/,%
num4 = num1>num2;//<,<=,>=,==,!=, ===,!==

//증감연산자
num4=1;
num4++;

num1=3;
num2='3';

num4='abc';
num4=null;
console.log(typeof num4);

console.log(num1==num2); // 값이 같아야 함.
console.log(num1 === num2); // 값과 타입 둘다 같아야 함.

console.log(num3);
console.log('NUM1 : '+num1);
