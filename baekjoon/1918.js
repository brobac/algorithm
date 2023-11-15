const order = {
  "*": 1,
  "/": 1,
  "+": 2,
  "-": 2,
  "(": 3,
};

const operatorList = ["*", "/", "+", "-"];

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("");

const result = [];
const stack = [];
input.forEach((v) => {
  if (v === "(") {
    stack.push("(");
  } else if (v === ")") {
    let t = stack.pop();
    while (t !== "(") {
      result.push(t);
      t = stack.pop();
    }
  } else if (operatorList.includes(v)) {
    if (stack.length === 0 || order[v] < order[stack[stack.length - 1]]) {
      stack.push(v);
    } else {
      while (stack.length !== 0 && order[stack[stack.length - 1]] <= order[v]) {
        result.push(stack.pop());
      }
      stack.push(v);
    }
  } else {
    result.push(v);
  }
});
while (stack.length !== 0) {
  result.push(stack.pop());
}

console.log(result.join(""));
