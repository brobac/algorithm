/*
 - https://www.acmicpc.net/problem/3986
 - 실버4
 - 스택
*/

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

let result = 0;
for (let i = 1; i < input.length; i++) {
  const stack = [];
  for (let j = 0; j < input[i].length; j++) {
    if (stack.length === 0) {
      stack.push(input[i][j]);
    } else if (stack[stack.length - 1] === input[i][j]) {
      stack.pop();
    } else {
      stack.push(input[i][j]);
    }
  }
  if (!stack.length) result++;
}
console.log(result);
