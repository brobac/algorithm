const [xPer, yBase, yLimit, yPer, n] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map((v) => +v);

const a요금 = n * xPer;
const b요금 = n <= yLimit ? yBase : yBase + (n - yLimit) * yPer;

console.log(Math.min(a요금, b요금));
