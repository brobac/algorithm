/*
 - https://www.acmicpc.net/problem/4396
 - 실버4
 - 구현
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = +input[0];
const mineArr = [
  Array(n).fill(null),
  ...input.slice(1, 1 + n).map((line) => [null, ...line.split(""), null]),
  Array(n).fill(null),
];
const playArr = [
  Array(n).fill(null),
  ...input.slice(1 + n).map((line) => [null, ...line.split(""), null]),
  Array(n).fill(null),
];
const result = Array.from(Array(n), () => Array(n));
const mineRange = [
  [-1, -1],
  [-1, 0],
  [-1, 1],
  [0, -1],
  [0, 1],
  [1, -1],
  [1, 0],
  [1, 1],
];
let mineClicked;
for (let i = 1; i <= n; i++) {
  if (mineClicked) break;
  for (let j = 1; j <= n; j++) {
    if (playArr[i][j] === "x" && mineArr[i][j] === "*") {
      mineClicked = true;
      break;
    }
  }
}
for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= n; j++) {
    if (playArr[i][j] === "x") {
      if (mineArr[i][j] === "*") {
        result[i - 1][j - 1] = "*";
      } else {
        let count = 0;
        mineRange.forEach(([a, b]) => {
          if (mineArr[i + a][j + b] === "*") count++;
        });
        result[i - 1][j - 1] = count;
      }
    } else if (mineArr[i][j] === "*" && mineClicked) {
      result[i - 1][j - 1] = "*";
    } else {
      result[i - 1][j - 1] = ".";
    }
  }
}
result.forEach((row) => console.log(row.join("")));
