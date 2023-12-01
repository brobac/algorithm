/*
 - https://www.acmicpc.net/problem/4358
 - 실버2
 - 자료 구조, 문자열, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵

 */
const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const count = {};

arr.forEach((v) => {
  if (count[v]) count[v]++;
  else count[v] = 1;
});

console.log(
  Object.entries(count)
    .map((v) => [v[0], ((v[1] / arr.length) * 100).toFixed(4)])
    .sort((a, b) => {
      if (a[0] < b[0]) return -1;
      else if (b[0] < a[0]) return 1;
      else return 0;
    })
    .map((v) => v.join(" "))
    .join("\n")
);
