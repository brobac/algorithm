const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1);

const result = [];
const queue = [];
const operation = {
  push(v) {
    queue.push(v);
  },
  pop() {
    const v = queue.shift();
    if (v) result.push(v);
    else result.push(-1);
  },
  size() {
    result.push(queue.length);
  },
  empty() {
    if (queue.length === 0) result.push(1);
    else result.push(0);
  },
  front() {
    const v = queue[0];
    if (v) result.push(v);
    else result.push(-1);
  },
  back() {
    const v = queue[queue.length - 1];
    if (v) result.push(v);
    else result.push(-1);
  },
};

input.forEach((v) => {
  const row = v.split(" ");
  if (row.length === 2) {
    operation.push(row[1]);
  } else {
    operation[row[0]]();
  }
});

console.log(result.join("\n"));
