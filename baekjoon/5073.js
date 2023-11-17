const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const nums = input
  .slice(0, input.length - 1)
  .map((line) => line.split(" ").map(Number));

for (let i = 0; i < nums.length; i++) {
  const arr = nums[i];
  arr.sort((a, b) => a - b);
  const [a, b, c] = arr;
  if (a + b <= c) {
    console.log("Invalid");
  } else if (a === b && a === c) {
    console.log("Equilateral");
  } else if (a === b || a === c || b === c) {
    console.log("Isosceles");
  } else {
    console.log("Scalene");
  }
}
