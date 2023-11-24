/*
 - https://www.acmicpc.net/submit/20436
 - 실버4
 - 구현 
 */

const pos = {
  q: [0, 0],
  w: [0, 1],
  e: [0, 2],
  r: [0, 3],
  t: [0, 4],
  y: [0, 5],
  u: [0, 6],
  i: [0, 7],
  o: [0, 8],
  p: [0, 9],

  a: [1, 0],
  s: [1, 1],
  d: [1, 2],
  f: [1, 3],
  g: [1, 4],
  h: [1, 5],
  j: [1, 6],
  k: [1, 7],
  l: [1, 8],

  z: [2, 0],
  x: [2, 1],
  c: [2, 2],
  v: [2, 3],
  b: [2, 4],
  n: [2, 5],
  m: [2, 6],
};

const leftKeys = [
  "q",
  "w",
  "e",
  "r",
  "t",
  "a",
  "s",
  "d",
  "f",
  "g",
  "z",
  "x",
  "c",
  "v",
];
const isLeftKey = (k) => {
  return leftKeys.includes(k);
};

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

let result = 0;
let [l, r] = input[0].split(" ");
input[1].split("").forEach((c) => {
  if (isLeftKey(c)) {
    const start = pos[l];
    const end = pos[c];
    const move = Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    result += move + 1;
    l = c;
  } else {
    const start = pos[r];
    const end = pos[c];
    const move = Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    result += move + 1;

    r = c;
  }
});

console.log(result);
