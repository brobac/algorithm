const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const n = +input[0];
const edgeList = input.slice(2).map((line) => line.split(" ").map((v) => +v));

const 인접리스트 = Array.from(Array(n + 1), () => []);

edgeList.forEach((v) => {
  const [a, b] = v;
  인접리스트[a].push(b);
  인접리스트[b].push(a);
});

const visited = [];

const bfs = (i) => {
  const queue = [];
  visited[i] = true;
  queue.push(i);
  while (queue.length !== 0) {
    const v = queue.shift();
    인접리스트[v].forEach((n) => {
      if (!visited[n]) {
        visited[n] = true;
        queue.push(n);
      }
    });
  }
};

bfs(1);
console.log(visited);
console.log(visited.filter((v) => v === true).length - 1);
