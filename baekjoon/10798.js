/*
 - https://www.acmicpc.net/problem/10798
 - 브론즈1
 - 구현, 문자열
 */

const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const max = Math.max(...arr.map((v) => v.length));
let result = "";
for (let i = 0; i < max; i++) {
  for (let j = 0; j < 5; j++) {
    if (i + 1 <= arr[j].length) result += arr[j][i];
  }
}
console.log(result);
