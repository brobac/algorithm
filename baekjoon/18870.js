/*
 - https://www.acmicpc.net/problem/18870
 - 실버2
 - 정렬, 값 / 좌표 압축
 */

const nums = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")[1]
  .split(" ")
  .map((v, i) => [+v, i])
  .sort((a, b) => a[0] - b[0]);
const result = Array(nums.length);
result[nums[0][1]] = 0;
let count = 0;
for (let i = 1; i < nums.length; i++) {
  if (nums[i - 1][0] < nums[i][0]) count++;
  result[nums[i][1]] = count;
}
console.log(result.join(" "));
