const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const [n, m] = input[0].split(" ").map((v) => +v);
const a = input[1].split(" ").map((v) => +v);

let count = 0;
let sum = a[0];

let i = 0;
let j = 0;

while (true) {
  if (sum === m) {
    count++;
    sum -= a[i];
    i++;
    if (j < n - 1) {
      j++;
      sum += a[j];
    }
  } else if (sum < m) {
    if (j === n - 1) break;
    if (j < n - 1) {
      j++;
      sum += a[j];
    }
  } else {
    // m < sum
    sum -= a[i];
    i++;
  }
}
console.log(count);
