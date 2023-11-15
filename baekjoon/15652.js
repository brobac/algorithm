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
    for (let i = 1; i < temp.length; i++) {
      if (temp[i - 1] > temp[i]) return;
    }
    ans.push([...temp]);
    return;
  }
  for (let i = 1; i <= n; i++) {
    temp.push(i);
    perm(idx + 1, n, r);
    temp.pop();
  }
};
perm(0, n, m);
console.log(ans.map((v) => v.join(" ")).join("\n"));
