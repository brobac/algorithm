const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = +input[0];
const [a, pa, b, pb] = input[1].split(" ").map((v) => +v);

const MaxACount = Math.trunc(n / pa);
const MaxBCount = Math.trunc(n / pb);
