/*
 - https://www.acmicpc.net/problem/10799
 - 실버2
 - 스택
*/

const input = require("fs").readFileSync("test.txt").toString().trim();

const stack = [];
let result = 0;
for (let i = 0; i < input.length; i++) {
  if (input[i] === "(") {
    stack.push("(");
  } else {
    stack.pop();
    if (input[i - 1] === "(") {
      result += stack.length;
    } else {
      result++;
    }
  }
}

console.log(result);
