/*
 - https://www.acmicpc.net/problem/1003
 - 실버3
 - 다이나믹 프로그래밍
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

const ans = Array(41);
ans[0] = [1, 0];
ans[1] = [0, 1];
const result = [];
for (let i = 2; i <= 40; i++) {
  ans[i] = [ans[i - 2][0] + ans[i - 1][0], ans[i - 2][1] + ans[i - 1][1]];
}
input.slice(1).forEach((n) => result.push(ans[n]));
console.log(result.map((v) => v.join(" ")).join("\n"));
