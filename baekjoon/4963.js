const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
let infoIdx = 0;
const m = [
  [-1, -1],
  [-1, 0],
  [-1, 1],
  [0, -1],
  [0, 1],
  [1, -1],
  [1, 0],
  [1, 1],
];
while (input[infoIdx] !== "0 0") {
  const [w, h] = input[infoIdx].split(" ").map((v) => +v);
  let count = 0;
  const visited = Array.from(Array(h), () => Array(w));
  const arr = input
    .slice(infoIdx + 1, infoIdx + h + 1)
    .map((line) => line.split(" ").map((v) => +v));
  const getAdjPos = (i, j) => {
    const res = [];
    m.forEach((v) => {
      const [a, b] = v;
      if (
        0 <= i + a &&
        i + a < h &&
        0 <= j + b &&
        j + b < w &&
        arr[i + a][j + b] === 1
      ) {
        res.push([i + a, j + b]);
      }
    });
    return res;
  };
  const dfs = (x, y) => {
    visited[x][y] = true;
    getAdjPos(x, y).forEach((v) => {
      const [a, b] = v;
      if (!visited[a][b]) {
        dfs(a, b);
      }
    });
  };

  for (let i = 0; i < h; i++) {
    for (let j = 0; j < w; j++) {
      if (!arr[i][j]) continue;
      if (!visited[i][j]) {
        count++;
        dfs(i, j);
      }
    }
  }
  console.log(count);
  infoIdx += h + 1;
}
