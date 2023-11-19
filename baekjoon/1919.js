const [a, b] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

let result = 0;

const counts = {};

for (let i = 0; i < a.length; i++) {
  if (counts[a[i]]) counts[a[i]]++;
  else counts[a[i]] = 1;
}

for (let i = 0; i < b.length; i++) {
  if (counts[b[i]]) counts[b[i]]--;
  else result++;
}
result += Object.values(counts).reduce((s, c) => s + c, 0);
console.log(result);
