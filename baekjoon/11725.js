const edges = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map((line) => line.split(" ").map(Number));

const adjList = Array.from(Array(edges.length + 2), () => []);
const visited = Array(edges.length + 2);
const parent = Array(edges.length + 2);
edges.forEach((edge) => {
  const [a, b] = edge;
  adjList[a].push(b);
  adjList[b].push(a);
});

const dfs = (i) => {
  visited[i] = true;
  adjList[i].forEach((v) => {
    if (!visited[v]) {
      parent[v] = i;
      dfs(v);
    }
  });
};
dfs(1);
console.log(parent.slice(2).join("\n"));
