/*
 - https://www.acmicpc.net/problem/14467
 - 브론즈1
*/
const ins = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1);

const cows = Array(11).fill(null);
let result = 0;
ins.forEach((line) => {
  const [pos, n] = line.split(" ").map(Number);

  if (cows[pos] === null) cows[pos] = n;
  else if (cows[pos] !== n) {
    cows[pos] = n;
    result++;
  }
});

console.log(result);
