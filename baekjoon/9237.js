const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = +input[0];
const list = input[1].split(" ").map((v) => +v);
list.sort((a, b) => b - a);
let result = 0;
list.forEach((v, i) => {
  if (result < v + i) result = v + i;
});
console.log(result + 2);
