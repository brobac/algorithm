const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = Number(input[0]);
const arr = input.slice(1).map(Number);
const stack = [];
const result = [];
let targetIdx = 0;
let i = 1;
while (targetIdx < n) {
  if (i <= arr[targetIdx]) {
    stack.push(i);
    console.log(stack);
    result.push("+");
    i++;
  }
  if (stack[stack.length - 1] === arr[targetIdx]) {
    targetIdx++;
    stack.pop();
    console.log(stack);
    result.push("-");
  } else if (arr[targetIdx] < stack[stack.length - 1]) {
    console.log("NO");
    return;
  }
}
console.log(result.join("\n"));
