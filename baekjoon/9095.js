const nums = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1);

const dp = Array(11);
dp[1] = 1;
dp[2] = 2;
dp[3] = 4;
dp[4] = 7;

for (let i = 5; i < 11; i++) {
  dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
}

const result = [];

nums.forEach((n) => {
  result.push(dp[n]);
});

console.log(result.join("\n"));
