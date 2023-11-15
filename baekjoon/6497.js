const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

let infoIdx = 0;
let edgesIdx = 1;
const result = [];
while (edgesIdx < input.length - 2) {
  const [n, line] = input[infoIdx].split(" ").map((v) => +v);
  const edges = input
    .slice(edgesIdx, edgesIdx + line)
    .map((v) => v.split(" ").map((n) => +n));
  infoIdx += line + 1;
  edgesIdx += line + 1;
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
  let min = 0;
  for (let i = 0; i < edges.length; i++) {
    const [a, b, w] = edges[i];
    if (find(a) !== find(b)) {
      union(a, b);
      min += w;
    }
  }

  const max = edges.reduce((sum, cur) => sum + cur[2], 0);
  result.push(max - min);
}

console.log(result.join("\n"));
