/*
 - https://www.acmicpc.net/problem/20922
 - 실버1
 - 투포인터

 반례 다 통과해서 맞왜틀 하고있다가 문제를 다시 읽어보니
 k가 100까지인데 숫자범위를 1~ 100으로 생각하고 counts 배열 사이즈를 101로 잡았다가 틀렸다
 */

const [[n, k], arr] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map((line) => line.split(" ").map(Number));
const counts = Array(100001).fill(0);

let start = (end = 0);
let length = 0;
let max = 0;

while (end < n) {
  counts[arr[end]]++;
  while (k < counts[arr[end]]) {
    counts[arr[start++]]--;
  }
  length = end - start + 1;
  max = Math.max(max, length);
  end++;
}
console.log(max);
