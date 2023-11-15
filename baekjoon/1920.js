const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = +input[0];
const m = +input[2];
const nList = input[1].split(" ").map(Number);
const mList = input[3].split(" ").map(Number);

const arr = Array(n + 1);
nList.forEach((v) => (arr[v] = true));
const res = [];
mList.forEach((v) => {
  if (arr[v]) res.push(1);
  else res.push(0);
});
console.log(res.join("\n"));
