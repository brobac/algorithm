/*
 - https://www.acmicpc.net/problem/19583
 - 실버2
 - 구현, 자료 구조, 문자열, 해시를 사용한 집합과 맵
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [S, E, Q] = input[0].split(" ").map((v) => {
  const [h, m] = v.split(":").map(Number);
  return h * 60 + m;
});

const beforeCheck = {};
const afterCheck = {};

const chatList = input.slice(1).map((line) => {
  const [t, name] = line.split(" ");
  const [h, m] = t.split(":").map(Number);
  return [h * 60 + m, name];
});

chatList.forEach(([time, name]) => {
  if (time <= S) beforeCheck[name] = true;
  else if (E <= time && time <= Q) {
    afterCheck[name] = true;
  }
});

let result = 0;
Object.keys(beforeCheck).forEach((v) => {
  if (afterCheck[v]) result++;
});
console.log(result);
