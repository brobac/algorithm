/*
 - https://www.acmicpc.net/problem/20053
 - 브론즈2
 - 구현
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

for (let i = 2; i < input.length; i += 2) {
  const arr = input[i].split(" ").map(Number);
  console.log(Math.min(...arr), Math.max(...arr));
}
