const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map((v) => v.split(""));

let count = 0;
for (let i = 0; i < 8; i++) {
  let j = 0;
  if (i % 2 === 1) j = 1;
  for (; j < 8; j += 2) {
    if (input[i][j] === "F") count++;
  }
}
console.log(count);
