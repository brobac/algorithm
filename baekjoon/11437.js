const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = +input[0];
const edges = input.slice(1, n).map((v) => v.split(" ").map((n) => +n));
const m = +input[n];
const wants = input.slice(n + 1).map((v) => v.split(" ").map((v) => +v));

const list = Array.from(Array(n + 1), () => []);
edges.forEach((v) => {
  const [a, b] = v;
  list[a].push(b);
  list[b].push(a);
});
const nodes = {};
for (let i = 1; i <= n; i++) {
  nodes[i] = { p: 0, depth: 0 };
}
nodes[1].부모 = 1;

const visited = Array(n + 1).fill(false);
const dfs = (i, depth) => {
  visited[i] = true;
  list[i].forEach((v) => {
    if (!visited[v]) {
      nodes[v].p = i;
      nodes[v].depth = depth;
      dfs(v, depth + 1);
    }
  });
};

dfs(1, 1);

const moveToDepth = (n, depth) => {
  let node = nodes[n];
  while (node.depth !== depth) {
    node = nodes[node.p];
  }

  return node;
};

const LCA = (a, b) => {
  if (nodes[a].depth !== nodes[b].depth) {
    if (nodes[a].depth > nodes[b].depth) {
    } else {
    }
  }
  while (a !== b) {}
};

wants.forEach((w) => {
  const [a, b] = w;
});
