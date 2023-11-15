const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const tc = +input[0];
let aNumIndex = 2;
for (let i = 0; i < tc; i++) {
  const a = input[aNumIndex].split(" ").map((v) => +v);
  const b = input[aNumIndex + 1].split(" ").map((v) => +v);
  aNumIndex += 3;

  a.sort((a, b) => a - b);
  b.sort((a, b) => a - b);

  let j = 0;
  let ans = [0];
  for (let i = 1; i <= a.length; i++) {
    let temp = ans[i - 1];
    for (; j < b.length; ) {
      if (a[i - 1] <= b[j]) {
        break;
      } else {
        temp++;
        j++;
      }
    }
    ans[i] = temp;
  }
  console.log(ans.reduce((sum, cur) => sum + cur, 0));
}
