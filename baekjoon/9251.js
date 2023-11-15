const [a, b] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const arr = Array.from(Array(a.length + 1), () => Array(b.length + 1));
arr[0].fill(0);
for (let i = 1; i <= a.length; i++) {
  arr[i][0] = 0;
}
for (let i = 1; i <= a.length; i++) {
  for (let j = 1; j <= b.length; j++) {
    if (a.charAt(i - 1) === b.charAt(j - 1)) {
      arr[i][j] = arr[i - 1][j - 1] + 1;
    } else {
      arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
    }
  }
}

console.log(arr[a.length][b.length]);
