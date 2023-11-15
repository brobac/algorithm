const arr = new Array(5);
require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map((v) => v.split(" "))
  .forEach((v, i) => (arr[i] = v));
const m = [
  [1, 0],
  [-1, 0],
  [0, -1],
  [0, 1],
];
const ans = [];

const solve = (x, y, str) => {
  if (str.length === 6) {
    ans.push(str);
    return;
  }
  m.forEach((v) => {
    const [a, b] = v;
    if (0 <= x + a && x + a < 5 && 0 <= y + b && y + b < 5) {
      solve(x + a, y + b, str + arr[x + a][y + b]);
    }
  });
};

for (let i = 0; i < 5; i++) {
  for (let j = 0; j < 5; j++) {
    solve(i, j, arr[i][j]);
  }
}

console.log(new Set(ans).size);
