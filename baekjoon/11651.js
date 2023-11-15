const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const list = input
  .slice(1)
  .map((v) => v.split(" ").map((v) => +v))
  .sort((a, b) => {
    if (a[1] < b[1]) return -1;
    if (a[1] > b[1]) return 1;
    return a[0] - b[0];
  });
console.log(list.map((v) => v.join(" ")).join("\n"));
