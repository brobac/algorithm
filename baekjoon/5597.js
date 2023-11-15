const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map((v) => +v);
const arr = Array.from(Array(31), () => false);
input.forEach((v) => (arr[v] = true));
for (let i = 1; i < 31; i++) {
  if (!arr[i]) console.log(i);
}
