/*
 - https://www.acmicpc.net/problem/1966
 - 실버3
 - 큐
 
 n이 작고 시간제한이 2초라서 queue안만들고 배열 shift를 사용해도 통과됐다.
*/

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

for (let i = 1; i < input.length; i += 2) {
  const [n, m] = input[i].split(" ").map(Number);
  const queue = [];
  const arr = input[i + 1].split(" ").map(Number);
  for (let j = 0; j < arr.length; j++) {
    queue.push({ v: arr[j], isTarget: j === m });
  }
  arr.sort((a, b) => a - b);
  let count = 0;
  while (true) {
    const cur = queue.shift();
    if (cur.v === arr[arr.length - 1]) {
      arr.pop();
      count++;
      if (cur.isTarget) break;
    } else {
      queue.push(cur);
    }
  }
  console.log(count);
}
