const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map((v) => +v);
const nums = input[1].split(" ").map((v) => +v);
const p = input.slice(2).map((line) => line.split(" ").map((v) => +v));
const arr = [0, nums[0]];

for (let i = 2; i <= n; i++) {
  arr[i] = arr[i - 1] + nums[i - 1];
}

const result = [];
p.forEach((v) => {
  const [s, e] = v;
  result.push(arr[Math.max(s, e)] - arr[Math.min(s, e) - 1]);
});

console.log(result.join("\n"));
