const [e, f, c] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split(" ")
  .map((v) => +v);

let b = e + f;
let count = 0;
while (c <= b) {
  const newB = Math.trunc(b / c);
  count += newB;
  b %= c;
  b += newB;
}

console.log(count);
