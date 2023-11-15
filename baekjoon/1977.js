const [M, N] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

const res = [];

for (let i = M; i <= N; i++) {
  if (Number.isInteger(Math.sqrt(i))) res.push(i);
}

if (res.length === 0) {
  console.log(-1);
} else {
  console.log(res.reduce((sum, cur) => sum + cur, 0));
  console.log(res[0]);
}
