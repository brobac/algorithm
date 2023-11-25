/*
 - https://www.acmicpc.net/problem/1018
 - 실버4
 - 브루트포스
*/

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const arr = input.slice(1).map((line) => line.split(""));
const board1 = Array.from(Array(8), () => Array(8));
const board2 = Array.from(Array(8), () => Array(8));
for (let i = 0; i < 8; i++) {
  for (let j = 0; j < 8; j++) {
    if ((i + j) % 2 === 0) {
      board1[i][j] = "W";
      board2[i][j] = "B";
    } else {
      board1[i][j] = "B";
      board2[i][j] = "W";
    }
  }
}
let result = Number.MAX_SAFE_INTEGER;
for (let i = 0; i <= n - 8; i++) {
  for (let j = 0; j <= m - 8; j++) {
    let count1 = (count2 = 0);
    for (let k = 0; k < 8; k++) {
      for (let l = 0; l < 8; l++) {
        if (arr[i + k][j + l] !== board1[k][l]) {
          count1++;
        }
        if (arr[i + k][j + l] !== board2[k][l]) {
          count2++;
        }
      }
    }
    result = Math.min(result, count1, count2);
  }
}

console.log(result);
