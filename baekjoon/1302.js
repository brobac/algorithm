/*
 - https://www.acmicpc.net/problem/1302
 - 실버4
 - 자료 구조, 문자열, 정렬, 해시를 사용한 집합과 맵
 */
const books = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1);

const counts = {};
books.forEach((v) => {
  counts[v] ? counts[v]++ : (counts[v] = 1);
});
const arr = Object.entries(counts).sort((a, b) => {
  if (a[1] !== b[1]) return b[1] - a[1];
  if (a[0] < b[0]) return -1;
  if (a[0] > b[0]) return 1;
  return 0;
});
console.log(arr);
console.log(arr[0][0]);
