/*
 - https://www.acmicpc.net/problem/2108
 - 실버3
 - 수학, 구현, 정렬
 */

const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map(Number)
  .sort((a, b) => a - b);

const mean = Math.round(arr.reduce((sum, cur) => (sum += cur), 0) / arr.length);
const median = arr[Math.trunc(arr.length / 2)];
const range = arr[arr.length - 1] - arr[0];
let mode = arr[0];

const counts = [[arr[0], 1]];
let j = 0;
for (let i = 1; i < arr.length; i++) {
  if (arr[i] === counts[j][0]) {
    counts[j][1]++;
  } else {
    counts.push([arr[i], 1]);
    j++;
  }
}
counts.sort((a, b) => b[1] - a[1]);
const maxCount = counts[0][1];
let i = 1;
while (i < counts.length && counts[i][1] === maxCount) {
  i++;
}
if (i === 1) {
  mode = counts[0][0];
} else {
  mode = counts.slice(0, i)[1][0];
}

console.log(mean === -0 ? 0 : mean);
console.log(median);
console.log(mode);
console.log(range);
