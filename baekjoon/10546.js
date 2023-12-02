/*
 - https://www.acmicpc.net/problem/10546
 - 실버4
 - 자료 구조, 해시를 사용한 집합과 맵
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const n = +input[0];
const participants = input.slice(1, 1 + n);
const complited = input.slice(1 + n);
const counts = {};
participants.forEach((v) => (counts[v] ? counts[v]++ : (counts[v] = 1)));
complited.forEach((v) => {
  if (counts[v] === 1) delete counts[v];
  else counts[v]--;
});

console.log(Object.keys(counts)[0]);
