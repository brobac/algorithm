/*
 - https://www.acmicpc.net/problem/1969
 - 실버4
 - 구현, 그리디, 문자열, 브루트포스
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const dnaList = input.slice(1);
const resultDna = [];
let distance = 0;
for (let i = 0; i < m; i++) {
  const counts = {};
  for (let j = 0; j < n; j++) {
    counts[dnaList[j][i]]
      ? counts[dnaList[j][i]]++
      : (counts[dnaList[j][i]] = 1);
  }
  const countsArr = Object.entries(counts).sort((a, b) => {
    if (a[1] !== b[1]) return b[1] - a[1];
    if (a[0] < b[0]) return -1;
    if (a[0] > b[0]) return 1;
    return 0;
  });
  resultDna.push(countsArr[0][0]);
  distance += n - countsArr[0][1];
}
console.log(resultDna.join(""));
console.log(distance);
