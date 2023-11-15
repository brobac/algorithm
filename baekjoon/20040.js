const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const n = +input[0][0];
const edges = input.slice(1).map((line) => line.split(" ").map(Number));
