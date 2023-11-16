/**
 사용가능한 비용은 정해져 있으니 2중for문 사용해서 비용이 초과되는 경우를 계산하는 일이 없도록 한다.
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const n = parseInt(input[0]);
const [a, pa, b, pb] = input[1].split(" ").map(Number);

let max = 0;
let aResult = 0;
let bResult = 0;

for (let i = 0; i < n; i++) {
  const aCount = Math.trunc((n - i) / pa);
  const bCount = Math.trunc(i / pb);
  const sum = a * aCount + b * bCount;
  if (max < sum) {
    max = sum;
    aResult = aCount;
    bResult = bCount;
  }
}
console.log(aResult, bResult);
