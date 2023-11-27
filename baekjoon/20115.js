/*
 - https://www.acmicpc.net/problem/20115
 - 실버3
 - 그리디
 */

const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")[1]
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);

const max = arr.pop();
let result = max;
arr.forEach((v) => {
  result += v / 2;
});
console.log(result);
