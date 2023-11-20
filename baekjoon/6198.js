/*
현재 타워에서 볼 수 있는 개수를 카운팅하는 것이 아닌
현재 타워를 볼 수 있는 타워의 개수를 카운팅해서 더함
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = Number(input[0]);
const arr = input.slice(1).map(Number);

let result = 0;
let stack = [arr[0]];

for (let i = 1; i < n; i++) {
  const cur = arr[i];
  while (stack[stack.length - 1] <= cur) {
    stack.pop();
  }
  result += stack.length;
  stack.push(cur);
}
console.log(result);
