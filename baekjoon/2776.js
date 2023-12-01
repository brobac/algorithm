/*
 - https://www.acmicpc.net/problem/2776
 - 실버4
 - 자료 구조, 정렬, 이분 탐색, 해시를 사용한 집합과 맵
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

for (let i = 1; i < input.length; i += 4) {
  const look = input[i + 1]
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);
  const check = input[i + 3].split(" ").map(Number);
  const result = [];
  check.forEach((v) => {
    let start = 0;
    let end = check.length - 1;
    let mid = Math.trunc((end + start) / 2);
    while (start <= end) {
      if (look[mid] === v) {
        result.push(1);
        break;
      } else if (look[mid] < v) {
        start = mid + 1;
        mid = Math.trunc((end + start) / 2);
      } else {
        end = mid - 1;
        mid = Math.trunc((end + start) / 2);
      }
    }
    if (look[mid] !== v) result.push(0);
  });
  console.log(result.join("\n"));
}
