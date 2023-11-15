const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const [n, m] = input[0].split(" ").map((v) => +v);
const s = {};
input.slice(1, n + 1).forEach((v) => {
  s[v] = 0;
});
input.slice(n + 1).forEach((v) => {
  if (s.hasOwnProperty(v)) s[v]++;
});

console.log(Object.values(s).reduce((sum, cur) => sum + cur, 0));
