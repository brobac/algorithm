/*
 - https://www.acmicpc.net/problem/1758
 - 실버4
 - 그리디, 정렬
 */

const result = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map(Number)
  .sort((a, b) => b - a)
  .map((v, i) => (v - i > 0 ? v - i : 0))
  .reduce((sum, cur) => (sum += cur), 0);

console.log(result);
