const [n, m] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split(" ")
  .map((v) => +v);

const check = Array.from(Array(n + 1), () => false);
const temp = [];
const ans = [];
const perm = (idx, n, r) => {
  if (idx === r) {
    ans.push([...temp]);
    return;
  }
  for (let i = 1; i <= n; i++) {
    if (!check[i]) {
      check[i] = true;
      temp.push(i);
      perm(idx + 1, n, r);
      temp.pop();
      check[i] = false;
    }
  }
};
perm(0, n, m);
ans.forEach((v) => console.log(v.join(" ")));
