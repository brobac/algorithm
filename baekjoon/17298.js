/*
 - https://www.acmicpc.net/problem/17298
 - 골드 4
 - 스택
*/

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = Number(input[0]);
const arr = input[1].split(" ").map(Number);
const stack = [arr[n - 1]];
const result = Array(n).fill(-1);
for (let i = n - 2; i >= 0; i--) {
  const cur = arr[i];
  if (cur < stack[stack.length - 1]) {
    result[i] = stack[stack.length - 1];
    stack.push(cur);
  } else {
    while (stack[stack.length - 1] <= cur) {
      stack.pop();
    }
    if (stack.length !== 0) {
      result[i] = stack[stack.length - 1];
    }
    stack.push(cur);
  }
}
console.log(result.join());

// 인터넷에서 찾아본 다른 로직

const solution = () => {
  const n = Number(input[0]);
  const arr = input[1].split(" ").map(Number);
  const stack = [0];
  const result = Array(n);

  for (let i = 1; i < n; i++) {
    while (arr[stack[stack.length - 1]] < arr[i]) {
      result[stack.pop()] = arr[i];
    }
    stack.push(i);
  }
  while (stack.length) {
    result[stack.pop()] = -1;
  }
  console.log(result.join(" "));
};

solution();
