/*
 - https://www.acmicpc.net/problem/12933
 - 실버3

 틀린 경우
 1. q u a c k 순서에 안맞을 때
 2. 울다가 말았을 때

 주의할 점
 1. 개수 카운트만 하면 안된다. 
 - 예) "quackquack"은 오리가 한 번 울고 또 울 수 있기 때문에 출력 : 1
 - 예) "qquuaacckk" 출력 : 2


*/

const s = require("fs").readFileSync("test.txt").toString().trim().split("");

const counts = {
  q: 0,
  u: 0,
  a: 0,
  c: 0,
  k: 0,
};

const arr = []; // true면 사용가능 flase면 사용불가능

for (let i = 0; i < s.length; i++) {
  const c = s[i];
  if (c === "q") {
    if (arr.some((v) => v)) {
      for (let j = 0; j < arr.length; j++) {
        if (arr[j]) {
          arr[j] = false;
          break;
        }
      }
    } else {
      arr.push(false);
    }
    counts.q++;
  } else if (c === "u") {
    if (counts.u < counts.q) {
      counts.u++;
    } else {
      console.log(-1);
      return;
    }
  } else if (c === "a") {
    if (counts.a < counts.u) {
      counts.a++;
    } else {
      console.log(-1);
      return;
    }
  } else if (c === "c") {
    if (counts.c < counts.a) {
      counts.c++;
    } else {
      console.log(-1);
      return;
    }
  } else if (c === "k") {
    if (counts.k < counts.c) {
      for (let j = 0; j < arr.length; j++) {
        if (!arr[j]) {
          arr[j] = true;
          break;
        }
      }
      counts.k++;
    } else {
      console.log(-1);
      return;
    }
  }
}
if (counts.q !== counts.k) {
  console.log(-1);
} else {
  console.log(arr.length);
}
