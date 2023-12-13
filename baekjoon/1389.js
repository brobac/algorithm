/*
 - https://www.acmicpc.net/problem/1389
 - 실버1
 -그래프 이론, 그래프 탐색, 너비 우선 탐색, 최단 경로, 플로이드–워셜
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const [N, M] = input[0].split(" ").map(Number);
const arr = input.slice(1).map((line) => line.split(" ").map(Number));
const adjList = {};
for (let i = 1; i <= N; i++) {
  adjList[i] = new Set();
}
arr.forEach(([a, b]) => {
  adjList[a].add(b);
  adjList[b].add(a);
});

const bfs = (i, visited, costArr, cost) => {
  const queue = [];
  queue.push([i, cost]);
  visited[i] = true;
  costArr[i] = cost;
  while (queue.length !== 0) {
    const [a, b] = queue.shift();
    [...adjList[a]].forEach((v) => {
      if (!visited[v]) {
        visited[v] = true;
        costArr[v] = b + 1;
        queue.push([v, b + 1]);
      }
    });
  }
};

let min = Number.MAX_SAFE_INTEGER;
let result = 0;
for (let i = 1; i <= N; i++) {
  const visited = Array(N + 1);
  const costArr = Array(N + 1).fill(0);
  bfs(i, visited, costArr, 0);
  const totalCost = costArr.reduce((sum, cur) => sum + cur, 0);
  if (totalCost < min) {
    min = totalCost;
    result = i;
  }
}
console.log(result);
