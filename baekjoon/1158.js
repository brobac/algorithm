const [n, k] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);
const arr = Array.from(Array(n), (_, i) => i + 1);
const result = [];
count = 1;
while (result.length < n) {
  const t = arr.shift();
  if (count === k) {
    result.push(t);
    count = 1;
  } else {
    arr.push(t);
    count++;
  }
}

console.log(`<${result.join(", ")}>`);
