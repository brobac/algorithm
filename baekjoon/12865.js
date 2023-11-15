const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const [n, m] = input[0].split(" ").map(Number);
const items = input.slice(1).map((line) => line.split(" ").map(Number));
const arr = Array.from(Array(n + 1), () => Array(m + 1).fill(0));
console.log(arr);
items.forEach((item, idx) => {
  const [w, v] = item;
  for (let i = 1; i <= m; i++) {}
});
