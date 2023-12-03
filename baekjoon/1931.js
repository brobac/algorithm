const times = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map((line) => line.split(" ").map(Number))
  .sort((a, b) => {
    if (a[1] === b[1]) return a[0] - b[0];
    return a[1] - b[1];
  });

let curIdx = 0;
let count = 1;
for (let i = 1; i < times.length; i++) {
  if (times[curIdx][1] <= times[i][0]) {
    curIdx = i;
    count++;
  }
}
console.log(count);
