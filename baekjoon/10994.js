/*
 - https://www.acmicpc.net/problem/10994
 - 실버4
 - 구현
 */

const n = +require("fs").readFileSync("test.txt").toString().trim();
const w = 1 + (n - 1) * 4;

const result = Array.from(Array(w), () => Array(w).fill(" "));

const center = Math.trunc(w / 2);
result[center][center] = "*";

for (let i = 2; center + i < w; i += 2) {
  for (let j = center - i; j <= center + i; j++) {
    result[j][center - i] = "*";
    result[j][center + i] = "*";
  }
  for (let j = center - i; j <= center + i; j++) {
    result[center - i][j] = "*";
    result[center + i][j] = "*";
  }
}

result.forEach((line) => console.log(line.join("")));
