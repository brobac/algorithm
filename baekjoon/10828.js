const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const stack = [];
const result = [];
const push = (v) => {
  stack.push(v);
};
const pop = () => {
  const v = stack.pop();
  if (!v) result.push(-1);
  else {
    result.push(v);
  }
};
const empty = () => {
  if (stack.length) {
    result.push(0);
  } else {
    result.push(1);
  }
};
const top = () => {
  if (stack.length) {
    result.push(stack[stack.length - 1]);
  } else {
    result.push(-1);
  }
};
const size = () => {
  result.push(stack.length);
};
const operation = {
  push,
  pop,
  empty,
  top,
  size,
};

const list = input.slice(1);

list.forEach((v) => {
  const row = v.split(" ");
  if (row.length === 2) {
    push(row[1]);
  } else {
    operation[row[0]]();
  }
});

console.log(result.join("\n"));
