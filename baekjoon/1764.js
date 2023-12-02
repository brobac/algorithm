/*
 - https://www.acmicpc.net/problem/1764
 - 실버4
 - 자료 구조, 문자열, 정렬, 해시를 사용한 집합과 맵
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n1, n2] = input[0].split(" ").map(Number);
const arr1 = input.slice(1, 1 + n1);
const arr2 = input.slice(1 + n1);

const counts = {};
arr1.forEach((v) => (counts[v] ? counts[v]++ : (counts[v] = 1)));
arr2.forEach((v) => (counts[v] ? counts[v]++ : (counts[v] = 1)));

const 듣보잡 = Object.entries(counts)
  .filter(([_, count]) => count === 2)
  .sort((a, b) => {
    if (a[0] < b[0]) return -1;
    if (b[0] < a[0]) return 1;
    return 0;
  })
  .map((v) => v[0]);

console.log(듣보잡.length);
console.log(듣보잡.join("\n"));
