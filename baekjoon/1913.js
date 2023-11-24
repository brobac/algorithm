/*
 - https://www.acmicpc.net/problem/1913
 - 실버3
 - 구현
 */

const [n, target] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

const result = Array.from(Array(n), () => Array(n).fill(0));
const center = Math.trunc(n / 2);
result[center][center] = 1;
let pos = center;
let num = 2;
const targetPos = [];
for (let i = 1; i <= Math.trunc(n / 2); i++) {
  pos--;
  for (let j = pos + 1; j <= pos + 2 * i; j++) {
    if (num === target) {
      targetPos.push(pos);
      targetPos.push(j);
    }
    result[pos][j] = num++;
  }
  for (let j = pos + 1; j <= pos + 2 * i; j++) {
    if (num === target) {
      targetPos.push(j);
      targetPos.push(pos + 2 * i);
    }
    result[j][pos + 2 * i] = num++;
  }
  for (let j = pos + 2 * i - 1; pos <= j; j--) {
    if (num === target) {
      targetPos.push(pos + 2 * i);
      targetPos.push(j);
    }
    result[pos + 2 * i][j] = num++;
  }
  for (let j = pos + 2 * i - 1; pos <= j; j--) {
    if (num === target) {
      targetPos.push(j);
      targetPos.push(pos);
    }
    result[j][pos] = num++;
  }
}

result.forEach((row) => console.log(row.join(" ")));
if (targetPos.length === 0) {
  console.log(`${center + 1} ${center + 1}`);
} else {
  console.log(targetPos.map((v) => v + 1).join(" "));
}
