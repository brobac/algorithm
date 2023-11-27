/*
 - https://www.acmicpc.net/problem/14916
 - 실버5
 - 수학, DP, 그리디
 */

let n = +require("fs").readFileSync("test.txt").toString().trim();

let result = 0;

result += Math.trunc(n / 5);
if (n % 5 === 4) {
  result += 2;
} else if (n % 5 === 3) {
  if (result === 0) result = -1;
  else result += 3;
} else if (n % 5 === 2) {
  result += 1;
} else if (n % 5 === 1) {
  if (result === 0) result = -1;
  else result += 2;
}

console.log(result);
