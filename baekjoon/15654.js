const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map((v) => +v);
const arr = input[1].split(" ").map((v) => +v);
arr.sort((a, b) => a - b);
const check = Array.from(Array(n + 1), () => false);

const temp = [];
const ans = [];
const perm = (idx, n, r) => {
  if (idx === r) {
    ans.push([...temp]);
    return;
  }
  for (let i = 0; i < n; i++) {
    if (!check[i]) {
      check[i] = true;
      temp.push(arr[i]);
      perm(idx + 1, n, r);
      temp.pop();
      check[i] = false;
    }
  }
};
perm(0, n, m);
console.log(ans.map((v) => v.join(" ")).join("\n"));
