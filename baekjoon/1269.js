/*
 - https://www.acmicpc.net/problem/1269
 - 실버4
 - 자료 구조, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵

 배열에 담고 다른 집합에 없는지 !includes()로 개수를 구하니 시간초과가 났다.
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const a = new Set(input[1].split(" "));
const b = new Set(input[2].split(" "));
let count = 0;
a.forEach((v) => {
  if (!b.has(v)) count++;
});
b.forEach((v) => {
  if (!a.has(v)) count++;
});
console.log(count);
