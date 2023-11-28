/*
 - https://www.acmicpc.net/problem/30804
 - 실버2
 - 구현, 브루트포스, 투포인터
 - 23.11.26(일) 솔브드 아레나 문제 - 실패

 3종류 되었을 때 앞쪽에 과일을 2종류 이상 빼야되는 경우가 생길 수 있는데 1종류만 빼면 2종류가 된다 생각하고 풀다가
 오래걸렸다.
 1 1 3 3 1 1 2 2 2 2
 에서 1 1 3 3 1 1 2 까지 가면 3종류인데
 여기서 1 1 2 될때까지 앞에서 빼야되는데
 3 3 1 1 2 까지만 빼버렸다
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const n = Number(input[0]);
const arr = input[1].split(" ").map(Number);

let kind = 0;
let max = 0;
const count = Array(10).fill(0);

let i = 0;
let j = 0;
while (kind <= 2 && j < n) {
  if (kind < 2) {
    if (count[arr[j]] === 0) kind++;
    count[arr[j]]++;
    if (max < j - i + 1) max = j - i + 1;
    j++;
  } else if (count[arr[j]]) {
    count[arr[j]]++;
    if (max < j - i + 1) max = j - i + 1;
    j++;
  } else {
    count[arr[j]]++;
    j++;
    kind++;
    while (2 < kind) {
      if (count[arr[i]] === 1) kind--;
      count[arr[i++]]--;
    }
  }
}
console.log(max);
