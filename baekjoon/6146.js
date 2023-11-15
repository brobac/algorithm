const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const [X, Y] = input[0].split(" ").map(Number);
const m = input.slice(1).map((line) => line.split(" ").map(Number));
const minX = Math.min(0, ...m.map((v) => v[0]));
const maxX = Math.max(0, ...m.map((v) => v[0]));
const minY = Math.min(0, ...m.map((v) => v[1]));
const maxY = Math.max(0, ...m.map((v) => v[1]));

// 제일 왼쪽 구덩이부터 제일 오른쪽 구덩이까지 길이(maxX - minX + 1)
// 제일 위쪽 구덩이부터 제일 아래쪽 구덩이까지 길이(maxY-  minY +  1)
// 바깥쪽으로 돌아갈 수 있게 태두리 길 만들어주기위해서 x,y +2씩
const arr = Array.from(Array(maxX - minX + 3), () =>
  Array(maxY - minY + 3).fill(1)
);
const visited = Array.from(Array(maxX - minX + 3), () =>
  Array(maxY - minY + 3).fill(1)
);

m.forEach((v) => {
  const [a, b] = v;
  arr[a - (minX - 1)][b - (minY - 1)] = 0;
});
const dir = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];
const getAdjList = (i, j) => {
  const result = [];
  dir.forEach((v) => {
    const [a, b] = v;
    const newI = i + a;
    const newJ = j + b;
    if (
      0 <= newI &&
      newI < maxX + 1 &&
      0 <= newJ &&
      newJ < maxY + 1 &&
      arr[newI][newJ]
    ) {
      result.push([newI, newJ]);
    }
  });
  return result;
};

let min = Infinity;
const targetPos = [X - (minX - 1), Y - (minY - 1)];
const startPos = [0 - (minX - 1), 0 - (minY - 1)];
const bfs = (i, j) => {
  const queue = [];
  queue.push([i, j, 1]);
  visited[i][j] = true;
  while (queue.length !== 0) {
    const [a, b, c] = queue.shift();
    if (a === targetPos[0] - 1 && b === targetPos[1] - 1) {
      min = Math.min(min, c);
      return;
    }
    getAdjList(a, b).forEach((e) => {
      const [u, v] = e;
      if (!visited[u][v]) {
        visited[u][v] = true;
        queue.push([u, v, c + 1]);
      }
    });
  }
};

bfs(startPos[0], startPos[1]);
console.log(min);
