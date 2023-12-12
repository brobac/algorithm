/*
 - https://www.acmicpc.net/problem/16918
 - 실버1
 - 구현, 그래프 이론, 그래프 탐색, 시뮬레이션
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

// R * C 사이즈 격자판의 N초 후 상태
const [R, C, N] = input[0].split(" ").map(Number);
const initialBoard = input.slice(1).map((line) => line.split(""));

const allCoveredBoard = Array.from(Array(R), () => Array(C).fill("O"));
const explodedBoard1 = Array.from(Array(R), () => Array(C).fill("O"));
const explodedBoard2 = Array.from(Array(R), () => Array(C).fill("O"));
const p = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

const printBoard = (board) => {
  console.log(board.map((line) => line.join("")).join("\n"));
};

const getAdjacentList = (i, j) => {
  const result = [];
  p.forEach(([a, b]) => {
    const newI = i + a;
    const newJ = j + b;
    if (0 <= newI && newI < R && 0 <= newJ && newJ < C) {
      result.push([newI, newJ]);
    }
  });
  return result;
};

for (let i = 0; i < R; i++) {
  for (let j = 0; j < C; j++) {
    if (initialBoard[i][j] === "O") {
      explodedBoard1[i][j] = ".";
      getAdjacentList(i, j).forEach(([a, b]) => {
        explodedBoard1[a][b] = ".";
      });
    }
  }
}

for (let i = 0; i < R; i++) {
  for (let j = 0; j < C; j++) {
    if (explodedBoard1[i][j] === "O") {
      explodedBoard2[i][j] = ".";
      getAdjacentList(i, j).forEach(([a, b]) => {
        explodedBoard2[a][b] = ".";
      });
    }
  }
}

if (N === 1) {
  printBoard(initialBoard);
} else if (N % 2 === 0) {
  printBoard(allCoveredBoard);
} else if (N % 4 === 3) {
  printBoard(explodedBoard1);
} else if (N % 4 === 1) {
  printBoard(explodedBoard2);
}
