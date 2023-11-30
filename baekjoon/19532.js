/*
 - https://www.acmicpc.net/problem/19532
 - 브론즈2
 - 수학, 브루트포스
 */
const [a, b, c, d, e, f] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

for (let i = -999; i <= 999; i++) {
  for (let j = -999; j <= 999; j++) {
    if (a * i + b * j === c && i * d + e * j === f) {
      console.log(i, j);
      return;
    }
  }
}
