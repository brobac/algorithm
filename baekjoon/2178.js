const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map((v) => +v);
const nums = input.slice(1).map((v) => v.split("").map(Number));

const p = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

const visited = Array.from(Array(n), () => Array(m).fill(false));

const getAdjList = (i, j) => {
  const result = [];
  p.forEach((v) => {
    const [a, b] = v;
    const newI = i + a;
    const newJ = j + b;
    if (0 <= newI && newI < n && 0 <= newJ && newJ < m && nums[newI][newJ]) {
      result.push([newI, newJ]);
    }
  });
  return result;
};
let min = Infinity;

const bfs = (i, j) => {
  const queue = [];
  queue.push([i, j, 1]);
  visited[i][j] = true;
  while (queue.length !== 0) {
    const [a, b, c] = queue.shift();
    if (a === n - 1 && b === m - 1) {
      min = Math.min(min, c);
      return;
    }
    getAdjList(a, b).forEach((pos) => {
      const [u, v] = pos;
      if (!visited[u][v]) {
        visited[u][v] = true;
        queue.push([u, v, c + 1]);
      }
    });
  }
};

bfs(0, 0);
console.log(min);
