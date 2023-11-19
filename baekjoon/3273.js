const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = Number(input[0]);
const arr = input[1].split(" ").map(Number);
arr.sort((a, b) => a - b);
const x = Number(input[2]);

let i = 0;
let j = n - 1;
let result = 0;
while (i < j) {
  const sum = arr[i] + arr[j];
  if (sum === x) {
    result++;
    i++;
    j--;
  } else if (sum < x) {
    i++;
  } else {
    j--;
  }
}
console.log(result);
