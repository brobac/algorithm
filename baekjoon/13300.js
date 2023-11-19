const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const [n, k] = input[0].split(" ").map(Number);
const arr = Array.from(Array(7), (_) => [0, 0]);
input
  .slice(1)
  .map((line) => line.split(" ").map(Number))
  .forEach((v) => arr[v[1]][v[0]]++);

const result = arr
  .slice(1)
  .reduce(
    (sum, cur) => (sum += Math.ceil(cur[0] / k) + Math.ceil(cur[1] / k)),
    0
  );

console.log(result);
