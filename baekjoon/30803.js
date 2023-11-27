/*
 - https://www.acmicpc.net/problem/30803
 - 실버4
 - 구현, 시뮬레이션
 - 23.11.26(일) 솔브드 아레나 문제로 품
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const arr = input[1].split(" ").map(Number);
const on = Array(arr.length).fill(true);
let sum = arr.reduce((sum, cur) => (sum += cur), 0);
console.log(sum);
const qList = input.slice(3).map((line) => line.split(" ").map(Number));
const result = [];
qList.forEach((q) => {
  if (q[0] === 1) {
    if (on[q[1] - 1]) {
      const diff = arr[q[1] - 1] - q[2];
      sum -= diff;
    }
    arr[q[1] - 1] = q[2];
  } else {
    if (on[q[1] - 1]) sum -= arr[q[1] - 1];
    else sum += arr[q[1] - 1];
    on[q[1] - 1] = !on[q[1] - 1];
  }
  result.push(sum);
});
console.log(result.join("\n"));
