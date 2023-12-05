/*
 - https://www.acmicpc.net/problem/17219
 - 실버4
 -자료 구조, 해시를 사용한 집합과 맵
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const memo = {};
for (let i = 1; i <= n; i++) {
  const [site, pw] = input[i].split(" ");
  memo[site] = pw;
}
const result = [];
for (let i = n + 1; i < input.length; i++) {
  result.push(memo[input[i]]);
}
console.log(result.join("\n"));
