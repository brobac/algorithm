/*
 - https://www.acmicpc.net/problem/17276
 - 실버2
 - 구현

 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

let i = 1;
while (i < input.length) {
  const [n, rotate] = input[i].split(" ").map(Number);
  let arr = input
    .slice(i + 1, i + 1 + n)
    .map((line) => line.split(" ").map(Number));
  i += n + 1;

  const posList = Array(8);

  posList[0] = Array.from(Array((n - 1) / 2), (_, i) => [(n - 1) / 2, i]);
  posList[1] = Array.from(Array((n - 1) / 2), (_, i) => [i, i]);
  posList[2] = Array.from(Array((n - 1) / 2), (_, i) => [i, (n - 1) / 2]);
  posList[3] = Array.from(Array((n - 1) / 2), (_, i) => [i, n - i - 1]);
  posList[4] = Array.from(Array((n - 1) / 2), (_, i) => [
    (n - 1) / 2,
    n - i - 1,
  ]);
  posList[5] = Array.from(Array((n - 1) / 2), (_, i) => [n - i - 1, n - i - 1]);
  posList[6] = Array.from(Array((n - 1) / 2), (_, i) => [
    n - i - 1,
    (n - 1) / 2,
  ]);
  posList[7] = Array.from(Array((n - 1) / 2), (_, i) => [n - i - 1, i]);
  if (rotate < 0) {
    const time = (rotate * -1) / 45;
    const temp = arr.map((row) => [...row]);
    for (let i = 0; i < 8; i++) {
      const values = posList[i].map(([row, col]) => arr[row][col]);
      posList[i - time < 0 ? 8 + i - time : i - time].forEach(
        ([row, col], idx) => {
          temp[row][col] = values[idx];
        }
      );
    }
    arr = temp;
  } else {
    const time = rotate / 45;
    const temp = arr.map((row) => [...row]);
    for (let i = 7; 0 <= i; i--) {
      const values = posList[i].map(([row, col]) => arr[row][col]);
      posList[(i + time) % 8].forEach(([row, col], idx) => {
        temp[row][col] = values[idx];
      });
    }
    arr = temp;
  }
  console.log(arr.map((line) => line.join(" ")).join("\n"));
}
