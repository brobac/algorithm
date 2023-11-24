/*
 - https://www.acmicpc.net/problem/1244
 - 실버4
 - 구현
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const n = Number(input[0]);
const switchList = input[1].split(" ").map(Number);
const actions = input.slice(3).map((line) => line.split(" ").map(Number));
actions.forEach(([sex, num]) => {
  if (sex == 1) {
    for (let i = num; i <= n; i += num) {
      switchList[i - 1] = switchList[i - 1] ? 0 : 1;
    }
  } else {
    let left = (right = 1);
    switchList[num - 1] = switchList[num - 1] ? 0 : 1;
    while (
      1 <= num - left &&
      num + right <= n &&
      switchList[num - left - 1] === switchList[num + right - 1]
    ) {
      switchList[num - left - 1] = switchList[num - left - 1] ? 0 : 1;
      switchList[num + right - 1] = switchList[num + right - 1] ? 0 : 1;
      left++;
      right++;
    }
  }
});
for (let i = 0; i < n; i += 20) {
  console.log(switchList.slice(i, i + 20).join(" "));
}
