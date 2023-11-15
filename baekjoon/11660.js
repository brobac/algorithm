const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const [n, m] = input[0].split(" ").map((v) => +v);
const nums = input
  .slice(1, n + 2)
  .map((line) => line.split(" ").map((v) => +v));
const q = input.slice(n + 1).map((line) => line.split(" ").map((v) => +v));
const arr = Array.from(Array(n + 1), () => Array(n + 1));

arr[0].fill(0);
for (let i = 1; i <= n; i++) {
  arr[i] = [0, ...nums[i - 1]];
}

for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= n; j++) {
    arr[i][j] = arr[i][j] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
  }
}

const result = [];

q.forEach((v) => {
  const [x1, y1, x2, y2] = v;

  result.push(
    arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1 - 1][y1 - 1]
  );
});

console.log(result.join("\n"));
