/*
 - https://www.acmicpc.net/problem/17626
 - 실버3
 - 다이나믹 프로그래밍, 브루트포스 알고리즘
 */
const n = +require("fs").readFileSync("test.txt").toString().trim();

const dp = Array(50001);
dp[0] = 0;

for (let i = 1; i <= n; i++) {
  dp[i] = dp[i - 1] + 1;
  for (let j = 1; j ** 2 <= i; j++) {
    dp[i] = Math.min(dp[i], dp[i - j ** 2] + 1);
  }
}
console.log(dp[n]);
