const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = +input[0];
const [a, b] = input[1].split(" ").map((v) => +v);
const edges = input.slice(3).map((line) => line.split(" ").map((v) => +v));

const list = Array.from(Array(n + 1), () => []);

edges.forEach((edge) => {
  const [u, v] = edge;
  list[u].push(v);
  list[v].push(u);
});
const visited = Array(n + 1);
let result = -1;
const dfs = (i, depth, target) => {
  visited[i] = true;
  for (let j = 0; j < list[i].length; j++) {
    if (!visited[list[i][j]]) {
      if (list[i][j] === target) {
        visited[list[i][j]] = true;
        result = depth;
        break;
      } else {
        visited[list[i][j]] = true;
        dfs(list[i][j], depth + 1, target);
      }
    }
  }
};

dfs(a, 1, b);
console.log(result);
