const [h, w, n, m] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

console.log(Math.trunc((h + n) / (n + 1)) * Math.trunc((w + m) / (m + 1)));
