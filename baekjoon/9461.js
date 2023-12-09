/*
 - https://www.acmicpc.net/problem/9461
 - 실버3
 - 수학, 다이나믹 프로그래밍
 */

const ans = [null, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9];
ans.length = 101;
const testCases = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map(Number);

const result = [];

const calcAns = (n) => {
  if (ans[n]) return;
  if (!ans[n - 1]) calcAns(n - 1);
  if (!ans[n - 5]) calcAns(n - 5);
  ans[n] = ans[n - 1] + ans[n - 5];
};
testCases.forEach((n) => {
  if (ans[n]) result.push(ans[n]);
  else {
    calcAns(n);
    result.push(ans[n]);
  }
});

console.log(result.join("\n"));
