/*
 - https://www.acmicpc.net/problem/22858
 - 실버3
 - 구현, 시뮬레이션

 p랑 d를 반대로 할당해서 20분 날렸다. 문제 꼼꼼히 읽자
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, k] = input[0].split(" ").map(Number);
let p = input[1].split(" ").map(Number);
const d = input[2].split(" ").map((v) => v - 1);

for (let i = 0; i < k; i++) {
  const temp = Array(n).fill(0);
  for (let j = 0; j < n; j++) {
    temp[d[j]] = p[j];
  }
  p = temp;
}
console.log(p.join(" "));
