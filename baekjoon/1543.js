const [s, w] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

let count = 0;
let i = 0;
let j = i + w.length;
while (i < s.length - (w.length - 1) && j <= s.length) {
  if (s.substring(i, j) === w) {
    count++;
    i += w.length;
    j = i + w.length;
  } else {
    i++;
    j++;
  }
}
console.log(count);
