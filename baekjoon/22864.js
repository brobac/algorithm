/*
 - https://www.acmicpc.net/problem/22864
 - 브론즈2
 - 수학, 구현, 그리디 알고리즘, 사칙연산, 시뮬레이션
 */

const [a, b, c, m] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

if (m < a) {
  console.log(0);
  return;
}
let result = 0;
let count = 0;
for (let i = 0; i < 24; i++) {
  if (count + a <= m) {
    count += a;
    result += b;
  } else {
    count = count - c < 0 ? 0 : count - c;
  }
}
console.log(result);
