/*
 - https://www.acmicpc.net/problem/11728
 - 실버5
 - 정렬, 투포인터
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map((line) => line.split(" ").map(Number));

const a = input[1];
const b = input[2];
const result = [];
let i = (j = 0);
while (i < a.length && j < b.length) {
  if (a[i] < b[j]) result.push(a[i++]);
  else result.push(b[j++]);
}

while (i < a.length) {
  result.push(a[i++]);
}
while (j < b.length) {
  result.push(b[j++]);
}
console.log(result.join(" "));
