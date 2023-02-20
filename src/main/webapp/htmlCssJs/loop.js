for(let i=0;i<5;i++){
    console.log(i);
}
console.log('---------------');

let ar =[1,3.2];
ar.push('abc'); //배열 끝에 요소 추가
let e=ar.pop(); // 배열 끝에 요소 삭제 후 반환
console.log(e);
ar.sort();
for(let i=0;i<ar.length;i++){
    console.log(ar[i]);
}

console.log(ar.includes(2));
window.alert("hello");