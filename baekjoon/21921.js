/*
 - https://www.acmicpc.net/problem/21921
 - 실버3
 - 누적 합, 슬라이딩 윈도우
 */

const [[n, x], arr] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map((line) => line.split(" ").map(Number));

let sum = arr.slice(0, x).reduce((sum, cur) => sum + cur, 0);
let max = sum;
let count = 1;

for (let i = 0; i < n - x; i++) {
  sum -= arr[i];
  sum += arr[i + x];
  if (max < sum) {
    max = sum;
    count = 1;
  } else if (max === sum) {
    count++;
  }
}

if (max === 0) {
  console.log("SAD");
} else {
  console.log(max);
  console.log(count);
}
