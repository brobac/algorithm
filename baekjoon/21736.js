/*
 - https://www.acmicpc.net/problem/21736
 - 실버2
 - 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const arr = input.slice(1).map((line) => line.split(""));

const startPos = {};
outer: for (let i = 0; i < n; i++) {
  for (let j = 0; j < m; j++) {
    if (arr[i][j] === "I") {
      startPos.row = i;
      startPos.col = j;
      break outer;
    }
  }
}
const p = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];
const visited = Array.from(Array(n), () => Array(m).fill(false));

const getAdjList = (i, j) => {
  const result = [];
  p.forEach((v) => {
    const [a, b] = v;
    const newI = i + a;
    const newJ = j + b;
    if (
      0 <= newI &&
      newI < n &&
      0 <= newJ &&
      newJ < m &&
      (arr[newI][newJ] === "O" || arr[newI][newJ] === "P")
    ) {
      result.push([newI, newJ]);
    }
  });
  return result;
};
let count = 0;
const dfs = (i, j) => {
  getAdjList(i, j).forEach(([a, b]) => {
    if (!visited[a][b]) {
      visited[a][b] = true;
      if (arr[a][b] === "P") count++;
      dfs(a, b);
    }
  });
};

dfs(startPos.row, startPos.col);

console.log(count ? count : "TT");
