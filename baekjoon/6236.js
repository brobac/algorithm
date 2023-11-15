const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map((v) => +v);
const list = input.slice(1).map((v) => +v);

let low = Math.max(...list);
let high = list.reduce((sum, cur) => (sum += cur), 0);

while (low <= high) {
  const mid = Math.trunc((low + high) / 2);
}

const check = (mid) => {
  let money = 0;
  let count = 0;
  list.forEach((v) => {
    if (v < mid) {
    }
  });
};
