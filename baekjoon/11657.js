const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const [N, M] = input[0].split(" ").map((v) => +v);
const edges = input.slice(1).map((line) => line.split(" ").map((v) => +v));

const adjList = Array.from(Array(N + 1), () => []);
edges.forEach((edge) => {
  const [u, v, w] = edge;
  adjList[u].push([v, w]);
});
const D = Array.from(Array(N + 1), () => Infinity);
D[1] = 0;
for (let i = 0; i < N - 1; i++) {
  for (let j = 1; j <= N; j++) {
    if (D[j] == Infinity) continue;
    adjList[j].forEach((e) => {
      const [v, w] = e;
      if (D[j] + w < D[v]) {
        D[v] = D[j] + w;
      }
    });
  }
}

let isInfinite = false;

for (let i = 1; i <= N; i++) {
  //forEach 말고 for문으로 짜야 break 가능
  adjList[i].forEach((e) => {
    const [v, w] = e;
    if (D[i] + w < D[v]) {
      isInfinite = true;
    }
  });
}

if (isInfinite) {
  console.log(-1);
} else {
  for (let i = 2; i <= N; i++) {
    if (D[i] === Infinity) console.log(-1);
    else console.log(D[i]);
  }
}
