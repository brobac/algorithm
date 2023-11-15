const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const [n] = input[0].split(" ").map((v) => +v);
const edges = input.slice(1).map((v) => v.split(" ").map((n) => +n));

edges.sort((a, b) => a[2] - b[2]);

const p = Array.from(Array(n), (_, i) => i);
const find = (u) => {
  if (u !== p[u]) {
    p[u] = find(p[u]);
  }
  return p[u];
};

const union = (u, v) => {
  const root1 = find(u);
  const root2 = find(v);
  p[root2] = root1;
};
let result = 0;
for (let i = 0; i < edges.length; i++) {
  const [a, b, w] = edges[i];
  if (find(a) !== find(b)) {
    union(a, b);
    result += w;
  }
}

console.log(result);
