/*
 - https://www.acmicpc.net/problem/15787
 - 실버2
 - 구현, 비트마스킹
 
 20분 소요
 다음에 비트마스킹으로 풀어봐야지
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const arr = input.slice(1).map((line) => line.split(" ").map(Number));
const train = Array.from(Array(n), () => Array(20).fill(0));
arr.forEach((v) => {
  if (v[0] === 1) {
    train[v[1] - 1][v[2] - 1] = 1;
  } else if (v[0] === 2) {
    train[v[1] - 1][v[2] - 1] = 0;
  } else if (v[0] === 3) {
    for (let i = 19; 1 <= i; i--) {
      train[v[1] - 1][i] = train[v[1] - 1][i - 1];
    }
    train[v[1] - 1][0] = 0;
  } else {
    for (let i = 0; i < 19; i++) {
      train[v[1] - 1][i] = train[v[1] - 1][i + 1];
    }
    train[v[1] - 1][19] = 0;
  }
});
const isSameTrain = (t1, t2) => {
  for (let i = 0; i < 20; i++) {
    if (t1[i] !== t2[i]) return false;
  }
  return true;
};
let count = 1;
for (let i = 1; i < n; i++) {
  let isSame = false;
  for (let j = 0; j < i; j++) {
    if (isSameTrain(train[i], train[j])) {
      isSame = true;
      break;
    }
  }
  if (!isSame) count++;
}
console.log(train);
console.log(count);
