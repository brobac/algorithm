const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map((line) => line.split(" ").map(Number));

const [n] = input[0];
const edges = input.slice(1);

const adjList = Array.from(Array(n + 1), () => []);
edges.forEach((e) => {
  const [a, b] = e;
  adjList[b].push(a);
});

const ans = Array.from(Array(n + 1), (_, i) => [i, 0]);

let visited = [];
const dfs = (i, p) => {
  adjList[i].forEach((v) => {
    if (!visited[v]) {
      if (ans[v][1]) {
        ans[p][1] += ans[v][1];
      } else {
        ans[p][1]++;
        dfs(v, p);
      }
    }
  });
};
let max = 0;
for (let i = 1; i <= n; i++) {
  visited = [];
  visited[i] = true;
  dfs(i, i);
  max = Math.max(max, ans[i][1]);
}
res = [];
for (let i = 1; i <= n; i++) {
  if (ans[i][1] === max) res.push(i);
}
console.log(res.join(" "));
