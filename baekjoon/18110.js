/*
 - https://www.acmicpc.net/problem/18110
 - 실버4
 - 수학, 구현, 정렬
 */

const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map(Number)
  .sort((a, b) => a - b);
if (arr.length === 0) {
  console.log(0);
  return;
}
const a = Math.round(arr.length * 0.15);

const sum = arr.slice(a, arr.length - a).reduce((sum, cur) => (sum += cur), 0);

console.log(Math.round(sum / (arr.length - 2 * a)));
