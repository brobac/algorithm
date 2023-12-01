/*
 - https://www.acmicpc.net/problem/20164
 - 골드5
 - 구현, 브루트포스, 재귀
 */

const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("")
  .map(Number);

const set = new Set();
const solution = (arr, prevCount) => {
  if (arr.length === 1) {
    const count = arr[0] % 2 === 1 ? 1 : 0;
    set.add(prevCount + count);
  } else if (arr.length === 2) {
    const count = arr.reduce((sum, cur) => (cur % 2 === 1 ? sum + 1 : sum), 0);
    solution(
      (arr[0] + arr[1]).toString().split("").map(Number),
      prevCount + count
    );
  } else {
    for (let i = 0; i < arr.length - 2; i++) {
      for (let j = i + 1; j < arr.length - 1; j++) {
        const count = arr.reduce(
          (sum, cur) => (cur % 2 === 1 ? sum + 1 : sum),
          0
        );
        const sum =
          Number(arr.slice(0, i + 1).join("")) +
          Number(arr.slice(i + 1, j + 1).join("")) +
          Number(arr.slice(j + 1).join(""));
        solution(sum.toString().split("").map(Number), prevCount + count);
      }
    }
  }
};
solution(arr, 0);
console.log(Math.min(...set), Math.max(...set));
