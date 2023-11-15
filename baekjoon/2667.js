const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const n = +input[0];
const nums = input.slice(1).map((line) => line.split("").map(Number));
const visited = Array.from(Array(n), () => Array(n));
const p = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];
const getAdjList = (i, j) => {
  const result = [];
  p.forEach((v) => {
    const [a, b] = v;
    const newI = i + a;
    const newJ = j + b;
    if (0 <= newI && newI < n && 0 <= newJ && newJ < n && nums[newI][newJ]) {
      result.push([newI, newJ]);
    }
  });
  return result;
};

let cnt = 0;
const dfs = (i, j) => {
  cnt++;
  visited[i][j] = true;
  getAdjList(i, j).forEach((v) => {
    const [a, b] = v;
    if (!visited[a][b]) {
      dfs(a, b);
    }
  });
};

const res = [];
for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    if (nums[i][j] && !visited[i][j]) {
      dfs(i, j);
      res.push(cnt);
      cnt = 0;
    }
  }
}
console.log(res.length);
res.sort((a, b) => a - b);
console.log(res.join("\n"));
