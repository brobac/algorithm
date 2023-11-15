const steps = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map((v) => +v);

const sum = [0, steps[0], steps[0] + steps[1]];

if (steps.length < 3) {
  console.log(sum[steps.length]);
  return;
}

for (let i = 3; i <= steps.length; i++) {
  sum[i] = Math.max(
    sum[i - 3] + steps[i - 2] + steps[i - 1],
    sum[i - 2] + steps[i - 1]
  );
}

console.log(sum[steps.length]);
