/*
 - https://www.acmicpc.net/problem/2630
 - 실버2
 - 분할정복, 재귀
 */
const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map((line) => line.split(" ").map(Number));

let white = 0;
let blue = 0;

const solution = (arr) => {
  if (arr.length === 1) {
    if (arr[0][0] === 0) white++;
    else blue++;
  } else {
    if (arr.every((row) => row.every((v) => v === 0))) white++;
    else if (arr.every((row) => row.every((v) => v === 1))) blue++;
    else {
      solution(
        arr.slice(0, arr.length / 2).map((row) => row.slice(0, row.length / 2))
      );
      solution(
        arr.slice(0, arr.length / 2).map((row) => row.slice(row.length / 2))
      );
      solution(
        arr.slice(arr.length / 2).map((row) => row.slice(0, row.length / 2))
      );
      solution(
        arr.slice(arr.length / 2).map((row) => row.slice(row.length / 2))
      );
    }
  }
};
solution(arr);
console.log(white);
console.log(blue);
