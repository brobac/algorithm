/*
 - https://www.acmicpc.net/problem/7568
 - 실버5
 - 구현, 브루트포스
 */
const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map((line) => line.split(" ").map(Number));

const result = Array(arr.length);

for (let i = 0; i < arr.length; i++) {
  let count = 1;
  for (let j = 0; j < arr.length; j++) {
    if (i === j) continue;
    if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
      count++;
    }
  }
  result[i] = count;
}
console.log(result.join(" "));
