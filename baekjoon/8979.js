const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const [n, target] = input[0].split(" ").map((v) => +v);
if (n === 1) {
  console.log(1);
  return;
}
const list = input
  .slice(1)
  .map((v) => v.split(" ").map((v) => +v))
  .sort((a, b) => {
    if (a[1] < b[1]) return 1;
    if (a[1] > b[1]) return -1;
    if (a[2] < b[2]) return 1;
    if (a[2] > b[2]) return -1;
    if (a[3] < b[3]) return 1;
    if (a[3] > b[3]) return -1;
    return 0;
  });

if (list[0][0] === target) {
  console.log(1);
  return;
}

const getIsSameRank = (a, b) => a[1] === b[1] && a[2] === b[2] && a[3] === b[3];
let rank = 1;
let count = 0;
for (let i = 1; i < list.length; i++) {
  if (getIsSameRank(list[i - 1], list[i])) {
    count++;
  } else if (count === 0) {
    rank++;
  } else {
    rank += count + 1;
    count = 0;
  }
  if (list[i][0] === target) {
    break;
  }
}
console.log(rank);
