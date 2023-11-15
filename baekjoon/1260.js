const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m, s] = input[0].split(" ").map((v) => +v);
const edges = input.slice(1).map((line) => line.split(" ").map((v) => +v));

const list = Array.from(Array(n + 1), () => []);
edges.forEach((v) => {
  const [a, b] = v;
  list[a].push(b);
  list[b].push(a);
});

list.forEach((v) => v.sort((a, b) => a - b));

const dfsVisited = Array(n + 1).fill(false);
const dfsResult = [];
const dfs = (i) => {
  dfsVisited[i] = true;
  dfsResult.push(i);
  list[i].forEach((v) => {
    if (!dfsVisited[v]) dfs(v);
  });
};
dfs(s);
console.log(dfsResult.join(" "));

const bfsVisited = Array(n + 1).fill(false);
const bfsResult = [];
const bfs = (i) => {
  const queue = [];
  bfsVisited[i] = true;
  bfsResult.push(i);
  queue.push(i);
  while (queue.length !== 0) {
    const t = queue.shift();
    list[t].forEach((v) => {
      if (!bfsVisited[v]) {
        bfsVisited[v] = true;
        bfsResult.push(v);
        queue.push(v);
      }
    });
  }
};

bfs(s);
console.log(bfsResult.join(" "));
