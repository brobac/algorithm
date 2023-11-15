const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1);

const isVPS = (input) => {
  const list = input.split("");
  const stack = [];
  for (let i = 0; i < list.length; i++) {
    if (list[i] === "(") {
      stack.push("(");
    } else if (stack.length === 0) {
      return false;
    } else {
      stack.pop();
    }
  }
  return stack.length === 0;
};

input.forEach((v) => {
  if (isVPS(v)) console.log("YES");
  else console.log("NO");
});
