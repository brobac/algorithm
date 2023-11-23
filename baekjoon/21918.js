/*
 - https://www.acmicpc.net/problem/21918
 - 브론즈2
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const arr = input[1].split(" ").map(Number);
const ins = input.slice(2);
ins.forEach((line) => {
  const [n, a, b] = line.split(" ").map(Number);
  if (n === 1) {
    arr[a - 1] = b;
  } else if (n === 2) {
    for (let i = a - 1; i <= b - 1; i++) {
      if (arr[i]) arr[i] = 0;
      else arr[i] = 1;
    }
  } else if (n === 3) {
    for (let i = a - 1; i <= b - 1; i++) {
      arr[i] = 0;
    }
  } else if (n === 4) {
    for (let i = a - 1; i <= b - 1; i++) {
      arr[i] = 1;
    }
  }
});
console.log(arr.join(" "));
