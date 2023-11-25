/*
 - https://www.acmicpc.net/problem/11866
 - 실버5
 - 구현, 자료구조, 큐
 */

const [n, k] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);
const arr = Array.from(Array(n), (_, i) => i + 1);

const result = [];

let i = 1;

while (arr.length) {
  if (i === k) {
    result.push(arr.shift());
    i = 1;
  } else {
    i++;
    arr.push(arr.shift());
  }
}
console.log(`<${result.join(", ")}>`);
