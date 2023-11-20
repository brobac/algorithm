const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = Number(input[0]);
const arr = input[1].split(" ").map(Number);
const result = Array(n).fill(0);
const stack = [[arr[0], 1]];
for (let i = 1; i < n; i++) {
  const cur = arr[i];
  while (0 < stack.length && stack[stack.length - 1][0] < cur) {
    stack.pop();
  }
  if (stack.length === 0) {
    result[i] = 0;
  } else {
    result[i] = stack[stack.length - 1][1];
  }
  stack.push([arr[i], i + 1]);
}

console.log(result.join(" "));
