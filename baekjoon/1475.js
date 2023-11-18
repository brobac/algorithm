const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("")
  .map(Number);
const counts = Array(10).fill(0);
arr.forEach((v) => counts[v]++);
counts[6] = Math.ceil((counts[6] + counts[9]) / 2);
counts[9] = counts[6];
console.log(Math.max(...counts));
