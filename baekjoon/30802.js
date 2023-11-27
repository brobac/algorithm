/*
 - https://www.acmicpc.net/problem/30802
 - 브론즈3
 - 수학, 구현, 사칙연산
 - 23.11.26(일) 솔브드 아레나 문제로 품
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const n = +input[0];
const arr = input[1].split(" ").map(Number);
const [t, p] = input[2].split(" ").map(Number);

const tResult = arr.reduce((sum, cur) => (sum += Math.ceil(cur / t)), 0);
const pResult = [Math.trunc(n / p), n - p * Math.trunc(n / p)];

console.log(tResult);
console.log(pResult.join(" "));
