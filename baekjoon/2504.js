/*
 - https://www.acmicpc.net/problem/2504
 - 골드5
 - 스택

 (2+(3*3)) * 2 + 2 * 3 으로 계산되는 방식으로 접근했다가 오래걸려서 다른사람 풀이 참조

 괄호가 열릴 때 곱해주고 닫을 때 나눠주는 방식으로
 4 + 18 + 6 이런식으로 된다

*/

const s = require("fs").readFileSync("test.txt").toString().trim();

const stack = [];
let result = 0;
let sum = 1;

for (let i = 0; i < s.length; i++) {
  if (s[i] === "(") {
    stack.push("(");
    sum *= 2;
  } else if (s[i] === "[") {
    stack.push("[");
    sum *= 3;
  } else if (s[i] === ")") {
    if (!stack.length || stack[stack.length - 1] !== "(") {
      console.log(0);
      return;
    }

    if (s[i - 1] === "(") {
      result += sum;
    }
    sum /= 2;
    stack.pop();
  } else if (s[i] === "]") {
    if (!stack.length || stack[stack.length - 1] !== "[") {
      console.log(0);
      return;
    }
    if (s[i - 1] === "[") {
      result += sum;
    }
    sum /= 3;
    stack.pop();
  }
}
if (stack.length) {
  console.log(0);
} else {
  console.log(result);
}
