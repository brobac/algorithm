const list = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map((line) => line.split(" ").map(Number));
console.log(list);
list.sort((a, b) => (a[0] !== b[0] ? a[0] - b[0] : a[1] - b[1]));
console.log(list.map((v) => v.join(" ")).join("\n"));
